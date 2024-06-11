package proyecto.grupal.lp.comidas.regionales.Services.jpa;
import proyecto.grupal.lp.comidas.regionales.Entities.Modulo;
import proyecto.grupal.lp.comidas.regionales.Repositories.ModuloRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService implements IModuloService {

	    @Autowired
	    private ModuloRepository moduloRepository;

	    public List<Modulo> getAllModulo() {
	        return moduloRepository.findAll();
	    }

	    public Optional<Modulo> getModuloById(Long id) {
	        return moduloRepository.findById(id);
	    }

	    public void postModulo(Modulo request) {
	        if (request.getEstado() == null){
	            request.setEstado(true);
	        }

	        moduloRepository.save(request);
	    }

	    public Modulo putModulo(Modulo request, Long id) {
	    	Modulo modulo = moduloRepository.findById(id).get();

	    	modulo.setClave(request.getClave());
	    	modulo.setNombre(request.getNombre());
	    	modulo.setIcon(request.getIcon());

	        if (request.getEstado() == null){
	            modulo.setEstado(modulo.getEstado());
	        } else {
	            modulo.setEstado(request.getEstado());
	        }

	        return moduloRepository.save(modulo);
	    }

	    public void deleteModulo(Long id) {
	        moduloRepository.deleteById(id);;
	    }

	
}
