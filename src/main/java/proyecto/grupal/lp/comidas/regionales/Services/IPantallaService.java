package proyecto.grupal.lp.comidas.regionales.Services;

import java.util.List;
import java.util.Optional;

import proyecto.grupal.lp.comidas.regionales.Entities.Pantalla;

public interface IPantallaService {
	List<Pantalla> getAllPantalla();
	Optional<Pantalla> getPantallaById(Long id);
	void postPantalla(Pantalla request);
	Pantalla putPantalla(Pantalla request, Long id);
	void deletePantalla(Long id);
	}

