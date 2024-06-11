package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Dto.LoginRequest;
import proyecto.grupal.lp.comidas.regionales.Dto.TokenDto;
import proyecto.grupal.lp.comidas.regionales.Entities.RefreshToken;
import proyecto.grupal.lp.comidas.regionales.Services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        return ResponseEntity.ok(authService.Login(loginRequest));
    }

    @PostMapping("/refreshToken/{token}")
    public ResponseEntity<?> refreshToken(@PathVariable String token){

        TokenDto tokenDtoR=authService.findByToken(token)
                .map(authService::verificarExpiracion
                )
                .map(RefreshToken::getUsuario)
                .map(u->{
                    authService.deleteRefreshToken(token);
                    String accessToken=authService.generarNuevoTOken(u.getUsername());
                    String newRefreshToken=authService.createRefreshToken(u.getUsername()).getToken();

                    TokenDto tokenDto= new TokenDto();
                    tokenDto.setToken(accessToken);
                    tokenDto.setRefreshToken(newRefreshToken);
                    return tokenDto;
                }).orElseThrow(()-> new RuntimeException("Refresh token invalido"));

        return ResponseEntity.ok(tokenDtoR);
    }

}
