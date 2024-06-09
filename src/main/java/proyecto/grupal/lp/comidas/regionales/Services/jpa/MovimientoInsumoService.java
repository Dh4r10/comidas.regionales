package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.MovimientoInsumo;
import proyecto.grupal.lp.comidas.regionales.Repositories.MovimientoInsumoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IMovimientoInsumoService;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoInsumoService implements IMovimientoInsumoService {
    //Esto esna funcion get
    @Autowired
    private MovimientoInsumoRepository movimientoInsumoRepository;
    public List<MovimientoInsumo> getMovimientoInsumo(){

        return movimientoInsumoRepository.findAll();
    }

    public Optional<MovimientoInsumo> ObtenerMovimientoInsumo(Long id) {
        return movimientoInsumoRepository.findById(id);
    }

    public void GuardarMovimientoInsumo(MovimientoInsumo movimientoInsumo) {
        if (movimientoInsumo.getEstado()==null){
            movimientoInsumo.setEstado(true);
        }
        movimientoInsumoRepository.save(movimientoInsumo);
    }
    public MovimientoInsumo ActualizarMovimientoInsumo(MovimientoInsumo movimientoInsumo, Long id) {
        MovimientoInsumo m = movimientoInsumoRepository.findById(id).get();


        if(movimientoInsumo.getEstado()==null){
            m.setEstado(m.getEstado());
        }
        else{
            m.setEstado(movimientoInsumo.getEstado());
        }
        return movimientoInsumoRepository.save(m);
    }
    public void EliminarMovimientoInsumo(Long id) {
        movimientoInsumoRepository.deleteById(id);
    }
}
