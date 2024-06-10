package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import proyecto.grupal.lp.comidas.regionales.Dto.LoginRequest;
import proyecto.grupal.lp.comidas.regionales.Dto.TokenDto;
import proyecto.grupal.lp.comidas.regionales.Repositories.UsuarioRepository;
import proyecto.grupal.lp.comidas.regionales.Services.AuthService;
import proyecto.grupal.lp.comidas.regionales.Security.jwt.JwtServices;

// Tu código adicional aquí

@Service
public class AuthServiceImpl implements AuthService  {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository iUsuarioRepository;
	
	@Autowired
	private JwtServices jwtServices; 
	

	@Override
	public TokenDto Login(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		UserDetails user=iUsuarioRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),loginRequest.getPassword()));
		String token=jwtServices.getToken(user);
		TokenDto tokenResponse= new TokenDto();
		tokenResponse.setToken(token);
		return tokenResponse;
	}
	
}
