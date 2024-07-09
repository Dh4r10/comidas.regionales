package proyecto.grupal.lp.comidas.regionales.Configuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import proyecto.grupal.lp.comidas.regionales.Security.jwt.JwtAuthenticationEntryPoint;

import proyecto.grupal.lp.comidas.regionales.Security.jwt.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	@Autowired
	private AuthenticationProvider authenticationProvider;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


	@Bean
    SecurityFilterChain securityFilterChainA(HttpSecurity httpSecurity) throws  Exception{
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
        		.authorizeHttpRequests(ar -> 
        		ar.requestMatchers("/api/v1/auth/**","/v3/api-docs/**",
								"/configuration/ui",
								"/swagger-resources/**",
								"/configuration/**",
								"/swagger-ui.html",
								"/swagger-ui/**",
								"/webjars/**")
						.permitAll()
						.requestMatchers(HttpMethod.POST,"/api/v1/usuarios/tipo-usuario/**")
						.permitAll()
						.anyRequest().authenticated()
        		).exceptionHandling((exception)->exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(sessionManager->
                sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        		.build();
        		
	}
}

