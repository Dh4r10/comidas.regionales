package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Pantalla;
import proyecto.grupal.lp.comidas.regionales.Repositories.PantallaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IPantallaService;

@Service
public class PantallaService implements IPantallaService{
	  @Autowired
	    private PantallaRepository pantallaRepository;

	    public List<Pantalla> getAllPantalla() {
	        return pantallaRepository.findAll();
	    }

	    public Optional<Pantalla> getPantallaById(Long id) {
	        return pantallaRepository.findById(id);
	    }

	    public void postPantalla(Pantalla request) {
	        if (request.getEstado() == null){
	            request.setEstado(true);
	        }

	        pantallaRepository.save(request);
	    }

	    public Pantalla putPantalla(Pantalla request, Long id) {
	    	Pantalla pantalla= pantallaRepository.findById(id).get();

	    	pantalla.setClave(request.getClave());
	    	pantalla.setNombre(request.getNombre());
	    	pantalla.setModulo(request.getModulo());
	    	pantalla.setUrl(request.getUrl());
	    	

	        if (request.getEstado() == null){
	            pantalla.setEstado(pantalla.getEstado());
	        } else {
	            pantalla.setEstado(request.getEstado());
	        }

	        return pantallaRepository.save(pantalla);
	    }

	    public void deletePantalla(Long id) {
	        pantallaRepository.deleteById(id);;
	    }

	
}
