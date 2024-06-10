package proyecto.grupal.lp.comidas.regionales.Services;

import java.util.List;
import java.util.Optional;

import proyecto.grupal.lp.comidas.regionales.Entities.Url;

public interface IUrlService {
	List<Url> getAllUrl();
	Optional<Url> getUrlById(Long id);
	void postUrl(Url request);
	Url putUrl(Url request, Long id);
	void deleteUrl(Long id);
	}

