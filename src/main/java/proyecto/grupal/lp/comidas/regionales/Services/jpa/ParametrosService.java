package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Parametros;
import proyecto.grupal.lp.comidas.regionales.Repositories.ParametrosRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IParametroServices;

import java.util.List;
import java.util.Optional;

@Service
public class ParametrosService implements IParametroServices {

    @Autowired
    private ParametrosRepository parametrosRepository;
    public List<Parametros> getParametros(){
      return parametrosRepository.findAll();
    }
    public Optional<Parametros> getParametrosById(Long id){
        return parametrosRepository.findById(id);
    }
    public void postParametros(Parametros parametros){
        if(parametros.getEstado()==null){
            parametros.setEstado(true);
        }
        parametrosRepository.save(parametros);
    }

    public Parametros putParametros(Parametros parametros, Long id){
        Parametros param=parametrosRepository.findById(id).get();
        param.setDescripcion(parametros.getDescripcion());
        param.setEstado(parametros.getEstado());
        param.setIdEstaticas(parametros.getIdEstaticas());
        if(parametros.getEstado()==null){
            param.setEstado(param.getEstado());
        }
        else{
            param.setEstado(parametros.getEstado());
        }
        return parametrosRepository.save(param);
    }

    public void deleteParametros(Long id){
        parametrosRepository.deleteById(id);
    }
}
