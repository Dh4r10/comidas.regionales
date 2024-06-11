package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.TipoUsuario;
import proyecto.grupal.lp.comidas.regionales.Entities.Usuario;
import proyecto.grupal.lp.comidas.regionales.Repositories.TipoUsuarioRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.UsuarioRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{
	  @Autowired
	    private UsuarioRepository usuarioRepository;
	  @Autowired
	  private PasswordEncoder passwordEncoder;

	  @Autowired
	  private TipoUsuarioRepository tipoUsuarioRepository;

	    public List<Usuario> getAllUsuario() {
	        return usuarioRepository.findAll();
	    }

	    public Optional<Usuario> getUsuarioById(Long id) {
	        return usuarioRepository.findById(id);
	    }

	    public Usuario postUsuario(Usuario request, Long idTipoUsuario) {

			TipoUsuario tipoUsuario=tipoUsuarioRepository.findById(idTipoUsuario)
					.orElseThrow(()->new RuntimeException("Tipo usuario not found"));

			request.setTipoUsuario(tipoUsuario);
	        if (request.getEstado() == null){
	            request.setEstado(true);
	        }
	        
	        if (request.getIdPublico() == null) {
	        	request.setIdPublico(UUID.randomUUID());
			}
			// CHANGE: Encriptando Contraseña
			request.setPassword(passwordEncoder.encode(request.getPassword()));
	       return  usuarioRepository.save(request);
	    }

	    public Usuario putUsuario(Usuario request, Long id) {
	    	Usuario usuario= usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario not found"));

	    	usuario.setTipoUsuario(request.getTipoUsuario());
	    	
	    	if (request.getIdPublico() == null) {
	    		request.setIdPublico(usuario.getIdPublico());
	    	} else {
	    		usuario.setIdPublico(request.getIdPublico());
	    	}
	    	usuario.setIdPublico(request.getIdPublico());
	    	usuario.setDni(request.getDni());
	    	usuario.setNombre(request.getNombre());
	    	usuario.setApellidoPaterno(request.getApellidoPaterno());
	    	usuario.setApellidoMaterno(request.getApellidoMaterno());
	    	usuario.setTelefono(request.getTelefono());
	    	usuario.setDireccion(request.getDireccion());
	    	usuario.setCorreo(request.getCorreo());
	    	usuario.setUsername(request.getUsername());
	    	usuario.setPassword(passwordEncoder.encode(request.getPassword()));
	    	usuario.setUltimoIngresoFecha(request.getUltimoIngresoFecha());
	    	usuario.setUltimoIngresoHora(request.getUltimoIngresoHora());
	    	usuario.setOnline(request.getOnline());

	    	
	        if (request.getEstado() == null){
	        	usuario.setEstado(usuario.getEstado());
	        } else {
	        	usuario.setEstado(request.getEstado());
	        }

	        return usuarioRepository.save(usuario);
	    }

	    public void deleteUsuario(Long id) {
	        usuarioRepository.deleteById(id);;
	    }

	
}
