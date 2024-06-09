package proyecto.grupal.lp.comidas.regionales.Services.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Ubicacion;
import proyecto.grupal.lp.comidas.regionales.Repositories.UbicacionRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IUbicacionService;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService implements IUbicacionService {
    //Esto esna funcion get
    @Autowired
    private UbicacionRepository ubicacionRepository;
    public List<Ubicacion> getUbicacion(){

        return ubicacionRepository.findAll();
    }

    public Optional<Ubicacion> ObtenerUbicacion(Long id) {
        return ubicacionRepository.findById(id);
    }

    public void GuardarUbicacion(Ubicacion ubicacion) {
        if (ubicacion.getEstado()==null){
            ubicacion.setEstado(true);
        }
        ubicacionRepository.save(ubicacion);
    }
    public Ubicacion ActualizarUbicacion(Ubicacion ubicacion, Long id) {
        Ubicacion u = ubicacionRepository.findById(id).get();
        u.setEstante(ubicacion.getEstante());
        u.setNivel(ubicacion.getNivel());

        if(ubicacion.getEstado()==null){
            u.setEstado(u.getEstado());
        }
        else{
            u.setEstado(ubicacion.getEstado());
        }
        return ubicacionRepository.save(u);
    }
    public void EliminarUbicacion(Long id) {
        ubicacionRepository.deleteById(id);
    }
}
