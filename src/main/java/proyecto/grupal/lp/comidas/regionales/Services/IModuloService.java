package proyecto.grupal.lp.comidas.regionales.Services;

import java.util.List;
import java.util.Optional;

import proyecto.grupal.lp.comidas.regionales.Entities.Modulo;

public interface IModuloService {
	List<Modulo> getAllModulo();
	Optional<Modulo> getModuloById(Long id);
	void postModulo(Modulo request);
	Modulo putModulo(Modulo request, Long id);
	void deleteModulo(Long id);
	}
