package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Url;
import proyecto.grupal.lp.comidas.regionales.Repositories.UrlRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IUrlService;

@Service
public class UrlService implements IUrlService{
	  @Autowired
	    private UrlRepository urlRepository;

	    public List<Url> getAllUrl() {
	        return urlRepository.findAll();
	    }

	    public Optional<Url> getUrlById(Long id) {
	        return urlRepository.findById(id);
	    }

	    public void postUrl(Url request) {
	        if (request.getEstado() == null){
	            request.setEstado(true);
	        }

	        urlRepository.save(request);
	    }

	    public Url putUrl(Url request, Long id) {
	    	Url url= urlRepository.findById(id).get();

	    	url.setNombre(request.getNombre());
	    	url.setPath(request.getPath());
	    	url.setUnionPath(request.getUnionPath());
	    	url.setAlias(request.getAlias());
	    	

	        if (request.getEstado() == null){
	        	url.setEstado(url.getEstado());
	        } else {
	        	url.setEstado(request.getEstado());
	        }

	        return urlRepository.save(url);
	    }

	    public void deleteUrl(Long id) {
	    	urlRepository.deleteById(id);;
	    }

	
}
