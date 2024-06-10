package proyecto.grupal.lp.comidas.regionales.Services;

import java.util.List;
import java.util.Optional;

import proyecto.grupal.lp.comidas.regionales.Entities.PermisoXEstablecimiento;

public interface IPermisoXEstablecimientoService {
	List<PermisoXEstablecimiento> getAllPermisoXEstablecimiento();
	Optional<PermisoXEstablecimiento> getPermisoXEstablecimientoById(Long id);
	void postPermisoXEstablecimiento(PermisoXEstablecimiento request);
	PermisoXEstablecimiento putPermisoXEstablecimiento(PermisoXEstablecimiento request, Long id);
	void deletePermisoXEstablecimiento(Long id);
	}
