package proyecto.grupal.lp.comidas.regionales.Services.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Pasillo;
import proyecto.grupal.lp.comidas.regionales.Repositories.PasilloRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IPasilloService;

import java.util.List;
import java.util.Optional;

@Service
public class PasilloService implements IPasilloService {
    //Esto esna funcion get
    @Autowired
    private PasilloRepository pasilloRepository;
    public List<Pasillo> getPasillo(){

        return pasilloRepository.findAll();
    }

    public Optional<Pasillo> ObtenerPasillo(Long id) {
        return pasilloRepository.findById(id);
    }

    public void GuardarPasillo(Pasillo pasillo) {
        if (pasillo.getEstado()==null){
            pasillo.setEstado(true);
        }
        pasilloRepository.save(pasillo);
    }
    public Pasillo ActualizarPasillo(Pasillo pasillo, Long id) {
        Pasillo p = pasilloRepository.findById(id).get();
        p.setNumero(pasillo.getNumero());
        p.setNombre(pasillo.getNombre());
        p.setDescripcion(pasillo.getDescripcion());

        if(pasillo.getEstado()==null){
            p.setEstado(p.getEstado());
        }
        else{
            p.setEstado(pasillo.getEstado());
        }
        return pasilloRepository.save(p);
    }
    public void EliminarPasillo(Long id) {
        pasilloRepository.deleteById(id);
    }
}
