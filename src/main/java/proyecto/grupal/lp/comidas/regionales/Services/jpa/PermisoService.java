package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Permiso;
import proyecto.grupal.lp.comidas.regionales.Repositories.PermisoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IPermisoService;

@Service
public class PermisoService implements IPermisoService{
	  @Autowired
	    private PermisoRepository permisoRepository;

	    public List<Permiso> getAllPermiso() {
	        return permisoRepository.findAll();
	    }

	    public Optional<Permiso> getPermisoById(Long id) {
	        return permisoRepository.findById(id);
	    }

	    public void postPermiso(Permiso request) {
	        if (request.getEstado() == null){
	            request.setEstado(true);
	        }

	        permisoRepository.save(request);
	    }

	    public Permiso putPermiso(Permiso request, Long id) {
	    	Permiso permiso= permisoRepository.findById(id).get();

	    	permiso.setPantalla(request.getPantalla());
	    	permiso.setTipoUsuario(request.getTipoUsuario());
	    	

	        if (request.getEstado() == null){
	        	permiso.setEstado(permiso.getEstado());
	        } else {
	        	permiso.setEstado(request.getEstado());
	        }

	        return permisoRepository.save(permiso);
	    }

	    public void deletePermiso(Long id) {
	    	permisoRepository.deleteById(id);;
	    }

	
}