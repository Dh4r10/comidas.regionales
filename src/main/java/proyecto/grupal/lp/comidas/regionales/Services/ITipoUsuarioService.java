package proyecto.grupal.lp.comidas.regionales.Services;
import java.util.List;
import java.util.Optional;

import proyecto.grupal.lp.comidas.regionales.Entities.TipoUsuario;

public interface ITipoUsuarioService {


	List<TipoUsuario> getAllTipoUsuario();
	Optional<TipoUsuario> getTipoUsuarioById(Long id);
	void postTipoUsuario(TipoUsuario request);
	TipoUsuario putTipoUsuario(TipoUsuario request, Long id);
	void deleteTipoUsuario(Long id);
	}


