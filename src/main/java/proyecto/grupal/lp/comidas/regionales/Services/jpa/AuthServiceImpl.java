package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import proyecto.grupal.lp.comidas.regionales.Dto.LoginRequest;
import proyecto.grupal.lp.comidas.regionales.Dto.TokenDto;
import proyecto.grupal.lp.comidas.regionales.Entities.RefreshToken;
import proyecto.grupal.lp.comidas.regionales.Repositories.RefreshTokenRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.UsuarioRepository;
import proyecto.grupal.lp.comidas.regionales.Services.AuthService;
import proyecto.grupal.lp.comidas.regionales.Security.jwt.JwtServices;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

// Tu código adicional aquí

@Service
public class AuthServiceImpl implements AuthService  {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository iUsuarioRepository;
	
	@Autowired
	private JwtServices jwtServices;
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	

	@Override
	public TokenDto Login(LoginRequest loginRequest) {

		UserDetails user=iUsuarioRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),loginRequest.getPassword()));
		String token=jwtServices.getToken(user);
		TokenDto tokenResponse= new TokenDto();
		RefreshToken refreshToken=createRefreshToken(user.getUsername());
		tokenResponse.setToken(token);
		tokenResponse.setRefreshToken(refreshToken.getToken());
		return tokenResponse;
	}


	public RefreshToken createRefreshToken(String username){
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshToken.setUsuario(iUsuarioRepository.findByUsername(username).orElseThrow());
		refreshToken.setExpiracion(Instant.now().plusMillis(3600000));
		return refreshTokenRepository.save(refreshToken);
	}



	public Optional<RefreshToken> findByToken(String token){
		return refreshTokenRepository.findByToken(token);
	}

	public RefreshToken verificarExpiracion(RefreshToken token){
		if(token.getExpiracion().compareTo(Instant.now())<0){
			refreshTokenRepository.delete(token);
			throw new RuntimeException(token.getToken() + " Refresh token expirado. Por favor logeate de nuevo ");
		}
		return token;
	}

	@Override
	public String generarNuevoTOken(String  username) {
		UserDetails user=iUsuarioRepository.findByUsername(username).orElseThrow();
		return jwtServices.getToken(user);
	}

	@Override
	public void deleteRefreshToken(String token) {
		RefreshToken refreshToken=refreshTokenRepository.findByToken(token).orElseThrow();
		refreshTokenRepository.delete(refreshToken);
	}

}
