package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Apertura;
import proyecto.grupal.lp.comidas.regionales.Repositories.AperturaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IAperturaServices;

import java.util.List;
import java.util.Optional;

@Service
public class AperturaService implements IAperturaServices {
    @Autowired
    private AperturaRepository aperturaRepository;
    public List<Apertura> getAperturas() {
        return aperturaRepository.findAll();
    }

    public Optional<Apertura> getAperturaById(Long id) {
        return aperturaRepository.findById(id);
    }

    public void postApertura(Apertura apertura) {
        if(apertura.getEstado()==null){
            apertura.setEstado(true);
        }
        aperturaRepository.save(apertura);
    }

    public Apertura putApertura(Long id, Apertura apertura) {
        Apertura aperturaActual = aperturaRepository.findById(id).get();
        aperturaActual.setFecha_cierre(apertura.getFecha_cierre());
        aperturaActual.setFecha_apertura(apertura.getFecha_apertura());
        aperturaActual.setCaja(apertura.getCaja());
        aperturaActual.setMonto_inicial(apertura.getMonto_inicial());

        if(aperturaActual.getEstado()==null){
            apertura.setEstado(aperturaActual.getEstado());
        }
        else{
            apertura.setEstado(aperturaActual.getEstado());
        }
        return aperturaRepository.save(apertura);
    }
    public void deleteApertura(Long id) {
        aperturaRepository.deleteById(id);
    }
}
