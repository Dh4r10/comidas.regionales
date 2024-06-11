package proyecto.grupal.lp.comidas.regionales.Security.jwt;

import java.security.Key;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import proyecto.grupal.lp.comidas.regionales.Entities.Sucursal;
import proyecto.grupal.lp.comidas.regionales.Entities.Usuario;
import proyecto.grupal.lp.comidas.regionales.Repositories.RefreshTokenRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.SucursalesRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.UsuarioRepository;

@Service
public class JwtServices {

    private static final String SECRET_KEY="1032SISTEMAGESTIONFINAZAS2000121383839BJNSNANBYSTEVENANDRE";
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    @Autowired
    private SucursalesRepository sucursalesRepository;

    public String getToken(UserDetails userDetails){
      Usuario usuario=usuarioRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        refreshTokenRepository.deleteByUsuario(usuario);

        Map<String,Object> extraclaims=new HashMap<>();
        extraclaims.put("tipo_usuario",usuario.getTipoUsuario().getId());
        Set<Long> sucursalesIDs= usuario.getResponsables()
                .stream().filter(Objects::nonNull)
                .map(r-> {

                    return r.getSucursal().getId();
                })
                .collect(Collectors.toSet());
        if(sucursalesIDs.stream().count()>0){
        Sucursal sucursal=sucursalesRepository.findById(sucursalesIDs.stream().findFirst().get())
               .orElseThrow();

        extraclaims.put("establecimiento",sucursal.getIdEstablecimiento().getId());
        }

        extraclaims.put("sucursales",sucursalesIDs);


        return getToken(extraclaims, userDetails);
    }



    private String getToken(Map<String,Object> extraclaims, UserDetails userDetails){

        return Jwts
                .builder()
                .setClaims(extraclaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+(50 * 60 * 1000)))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] bytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    public String getUsernameFromToken(String token) {
        return getClaims(token,Claims::getSubject);
    }

    private Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaims(String token, Function<Claims,T> claimsResolver ){
        final Claims claims= getClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpirationDate(String token){
        return getClaims(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpirationDate(token).before(new Date());
    }
}
