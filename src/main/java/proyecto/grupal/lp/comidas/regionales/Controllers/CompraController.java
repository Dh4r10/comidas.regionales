package proyecto.grupal.lp.comidas.regionales.Controllers;

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
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Compra;
import proyecto.grupal.lp.comidas.regionales.Security.jwt.JwtAuthenticationEntryPoint;
import proyecto.grupal.lp.comidas.regionales.Security.jwt.JwtAuthenticationFilter;
import proyecto.grupal.lp.comidas.regionales.Services.ICompraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/compra")
public class CompraController {
    @Autowired
    private ICompraService iCompraService;
    @GetMapping
    public List<Compra> getCompra() {
        return iCompraService.getCompra();
    }
    @GetMapping("/{id}")
    public Optional<Compra> getCompra(@PathVariable Long id) {
        return iCompraService.ObtenerCompra(id);
    }

    @PostMapping
    public Compra addCompra(@RequestBody Compra compra) {
        iCompraService.GuardarCompra(compra);
        return compra;
    }

    @PutMapping("/{id}")
    public Compra updateCompra(@RequestBody Compra compra,@PathVariable Long id) {
        return iCompraService.ActualizarCompra(compra, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCompra(@PathVariable Long id) {
        iCompraService.EliminarCompra(id);
        return "Compra "+id+" eliminado";
    }

    @Configuration

    public static class SecurityConfig {

        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;
        @Autowired
        private AuthenticationProvider authenticationProvider;
        @Autowired
        private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
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
                            .anyRequest().permitAll()
                    ).exceptionHandling((exception)->exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                    .sessionManagement(sessionManager->
                    sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();

        }
    }
}
