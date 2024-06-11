package proyecto.grupal.lp.comidas.regionales.Services;

import java.util.List;
import java.util.Optional;

import proyecto.grupal.lp.comidas.regionales.Entities.Permiso;

public interface IPermisoService {
		List<Permiso> getAllPermiso();
		Optional<Permiso> getPermisoById(Long id);
		void postPermiso(Permiso request);
		Permiso putPermiso(Permiso request, Long id);
		void deletePermiso(Long id);
		}

