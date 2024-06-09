package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Caja;
import proyecto.grupal.lp.comidas.regionales.Repositories.CajaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ICajaServices;

import java.util.List;
import java.util.Optional;

@Service
public class CajaService implements ICajaServices {

    @Autowired
    private CajaRepository cajaRepository;
    public List<Caja> getCaja(){
        return cajaRepository.findAll();
    }

    public Optional<Caja> getCajaById(Long id){
        return cajaRepository.findById(id);
    }

    public void postCaja( Caja caja){
        if(caja.getEstado()==null){
            caja.setEstado(true);
        }
        cajaRepository.save(caja);
    }

    public Caja putCaja(Long id, Caja caja){
        Caja newCaja=cajaRepository.findById(id).get();

        newCaja.setNombre(caja.getNombre());
        newCaja.setDescripcion(caja.getDescripcion());
        newCaja.setIdSucursal(caja.getIdSucursal());

        if(caja.getEstado()==null){
            newCaja.setEstado(newCaja.getEstado());
        }
        else{
            newCaja.setEstado(caja.getEstado());
        }
        return cajaRepository.save(newCaja);
    }

    public void deleteCaja(Long id){
        cajaRepository.deleteById(id);
    }


}
