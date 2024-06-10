package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import java.util.List;
import java.util.Optional;
import proyecto.grupal.lp.comidas.regionales.Entities.TipoUsuario;
import proyecto.grupal.lp.comidas.regionales.Repositories.TipoUsuarioRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ITipoUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService implements ITipoUsuarioService{
	  @Autowired
	    private TipoUsuarioRepository tipoUsuarioRepository;

	    public List<TipoUsuario> getAllTipoUsuario() {
	        return tipoUsuarioRepository.findAll();
	    }

	    public Optional<TipoUsuario> getTipoUsuarioById(Long id) {
	        return tipoUsuarioRepository.findById(id);
	    }

	    public void postTipoUsuario(TipoUsuario request) {
	        if (request.getEstado() == null){
	            request.setEstado(true);
	        }

	        tipoUsuarioRepository.save(request);
	    }

	    public TipoUsuario putTipoUsuario(TipoUsuario request, Long id) {
	    	TipoUsuario tipoUsuario= tipoUsuarioRepository.findById(id).get();

	    	tipoUsuario.setNombre(request.getNombre());
	    	tipoUsuario.setDescripcion(request.getDescripcion());
	    	

	        if (request.getEstado() == null){
	        	tipoUsuario.setEstado(tipoUsuario.getEstado());
	        } else {
	        	tipoUsuario.setEstado(request.getEstado());
	        }

	        return tipoUsuarioRepository.save(tipoUsuario);
	    }

	    public void deleteTipoUsuario(Long id) {
	    	tipoUsuarioRepository.deleteById(id);;
	    }

	
}