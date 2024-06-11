package proyecto.grupal.lp.comidas.regionales.Services;

import org.springframework.security.core.userdetails.UserDetails;
import proyecto.grupal.lp.comidas.regionales.Dto.LoginRequest;
import proyecto.grupal.lp.comidas.regionales.Dto.TokenDto;
import proyecto.grupal.lp.comidas.regionales.Entities.RefreshToken;

import java.util.Optional;

public interface AuthService {
	
	TokenDto Login(LoginRequest loginRequest);
	RefreshToken createRefreshToken(String username);
	Optional<RefreshToken> findByToken(String token);
	RefreshToken verificarExpiracion(RefreshToken token);
	String generarNuevoTOken(String username);

	void deleteRefreshToken(String token);
}
