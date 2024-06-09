package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.MovimientoAdicional;
import proyecto.grupal.lp.comidas.regionales.Repositories.MovimientoAdicionalRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IMovimientoAdicionalServices;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoAdicionalService implements IMovimientoAdicionalServices {

    @Autowired
    private MovimientoAdicionalRepository movimientoAdicionalRepository;

    public List<MovimientoAdicional> getMovimientoAdicional() {
        return movimientoAdicionalRepository.findAll();
    }

    public Optional<MovimientoAdicional> getMovimientoAdicionalById(Long id) {
        return movimientoAdicionalRepository.findById(id);
    }

    public void postMovimientoAdicional(MovimientoAdicional movimientoAdicional) {
        if(movimientoAdicional.getEstado()==null){
            movimientoAdicional.setEstado(true);
        }
        movimientoAdicionalRepository.save(movimientoAdicional);
    }

    public MovimientoAdicional putMovimientoAdicional(MovimientoAdicional movimientoAdicional, Long id) {
        MovimientoAdicional movimientoAd = movimientoAdicionalRepository.findById(id).get();

        movimientoAd.setDescripcion(movimientoAdicional.getDescripcion());
        movimientoAd.setTipoMovimiento(movimientoAdicional.getTipoMovimiento());
        movimientoAd.setMonto(movimientoAdicional.getMonto());
        movimientoAd.setTotal(movimientoAdicional.getTotal());
        movimientoAd.setFecha(movimientoAdicional.getFecha());
        movimientoAd.setTipoMovimiento(movimientoAdicional.getTipoMovimiento());

        if(movimientoAdicional.getEstado()==null){
            movimientoAdicional.setEstado(movimientoAdicional.getEstado());
        }
        else{
            movimientoAdicional.setEstado(movimientoAd.getEstado());
        }
    return movimientoAdicionalRepository.save(movimientoAd);

    }

    public void deleteMovimientoAdicional(Long id) {
        movimientoAdicionalRepository.deleteById(id);
    }
}
