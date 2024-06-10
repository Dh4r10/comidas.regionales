package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupal.lp.comidas.regionales.Entities.PermisoXEstablecimiento;
import proyecto.grupal.lp.comidas.regionales.Repositories.PermisoXEstablecimientoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IPermisoXEstablecimientoService;

@Service
public class PermisoXEstablecimientoService implements IPermisoXEstablecimientoService{
	  @Autowired
	    private PermisoXEstablecimientoRepository permisoXEstablecimientoRepository;

	    public List<PermisoXEstablecimiento> getAllPermisoXEstablecimiento() {
	        return permisoXEstablecimientoRepository.findAll();
	    }

	    public Optional<PermisoXEstablecimiento> getPermisoXEstablecimientoById(Long id) {
	        return permisoXEstablecimientoRepository.findById(id);
	    }

	    public void postPermisoXEstablecimiento(PermisoXEstablecimiento request) {
	        if (request.getEstado() == null){
	            request.setEstado(true);
	        }

	        permisoXEstablecimientoRepository.save(request);
	    }

	    public PermisoXEstablecimiento putPermisoXEstablecimiento(PermisoXEstablecimiento request, Long id) {
	    	PermisoXEstablecimiento permisoXEstablecimiento= permisoXEstablecimientoRepository.findById(id).get();

	    	permisoXEstablecimiento.setPermiso(request.getPermiso());
	    	

	        if (request.getEstado() == null){
	        	permisoXEstablecimiento.setEstado(permisoXEstablecimiento.getEstado());
	        } else {
	        	permisoXEstablecimiento.setEstado(request.getEstado());
	        }

	        return permisoXEstablecimientoRepository.save(permisoXEstablecimiento);
	    }

	    public void deletePermisoXEstablecimiento(Long id) {
	    	permisoXEstablecimientoRepository.deleteById(id);;
	    }

	
}
