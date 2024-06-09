package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.RepresentanteLegal;
import proyecto.grupal.lp.comidas.regionales.Repositories.RepresentanteLegalRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IRepresentateLegalServices;

import java.util.List;
import java.util.Optional;

@Service
public class RepresentanteLegalService implements IRepresentateLegalServices {

    @Autowired
    private RepresentanteLegalRepository repository;

    public List<RepresentanteLegal> getRepresentanteLegal() {
        return repository.findAll();
    }
    public Optional<RepresentanteLegal> getRepresentanteLegalById(Long id) {
        return repository.findById(id);
    }
    public void  postRepresentanteLegal(RepresentanteLegal representanteLegal) {
        if(representanteLegal.getEstado() ==null){
            representanteLegal.setEstado(true);
        }
        repository.save(representanteLegal);
    }

    public RepresentanteLegal putRepresentanteLegal(RepresentanteLegal representanteLegal, Long id) {
        RepresentanteLegal relegal=repository.findById(id).get();
        relegal.setNombre(representanteLegal.getNombre());
        relegal.setApellido_paterno(representanteLegal.getApellido_paterno());
        relegal.setApellido_materno(representanteLegal.getApellido_materno());
        relegal.setDni(representanteLegal.getDni());
        relegal.setCorreo(representanteLegal.getCorreo());
        relegal.setTelefono(representanteLegal.getTelefono());

        if(representanteLegal.getEstado()==null){
            relegal.setEstado(relegal.getEstado());
        }
        else{
            relegal.setEstado(representanteLegal.getEstado());
        }
        return repository.save(relegal);

    }
    public void deleteRepresentanteLegal(Long id) {
        repository.deleteById(id);
    }
}
