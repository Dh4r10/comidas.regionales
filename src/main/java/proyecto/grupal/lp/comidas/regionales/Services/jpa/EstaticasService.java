package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Estaticas;
import proyecto.grupal.lp.comidas.regionales.Repositories.EstaticasRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IEstaticasServices;

import java.util.List;
import java.util.Optional;

@Service
public class EstaticasService implements IEstaticasServices {

    @Autowired
    private EstaticasRepository repository;
    public List<Estaticas> getEstaticas(){
        return repository.findAll();
    }

    public Optional<Estaticas> getEstaticasById(Long id){
        return repository.findById(id);
    }

    public void postEstaticas(Estaticas estaticas){
        //Esta lógica es para que el true se ponga cuando solo haya un put
        if(estaticas.getEstado()==null){
            estaticas.setEstado(true);
        }
        repository.save(estaticas);
    }

    public Estaticas putEstaticas(Estaticas esta , Long id){
        //Aquí estamos almacenando
      Estaticas     estaticas = repository.findById(id).get();

      estaticas.setNombre(esta.getNombre());
      estaticas.setDescripcion(esta.getDescripcion());

      if(esta.getEstado()==null){
          estaticas.setEstado(estaticas.getEstado());
      }
      else{
          estaticas.setEstado(esta.getEstado());
      }
      return repository.save(estaticas);
    }

    public void deleteEstaticas(Long id){
        repository.deleteById(id);
    }
}
