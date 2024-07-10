package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Establecimiento;
import proyecto.grupal.lp.comidas.regionales.Repositories.EstablecimientoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IEstableciminetoServices;

import java.util.List;
import java.util.Optional;
@Service
public class EstablecimientoService implements IEstableciminetoServices {

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    public List<Establecimiento> getEstablecimiento(){
        return  establecimientoRepository.findAll();
    }

    public Optional<Establecimiento> getEstablecimientoCondicionado(Long idE){
        return establecimientoRepository.findById(idE);
    }

    //Aquí estamos filtrando las opociones del get por cada id
    public Optional<Establecimiento> getEstablecimientoId(Long id){
        return establecimientoRepository.findById(id);
    }

    public void postEstablecimiento(Establecimiento establecimiento){
        if(establecimiento.getEstado() == null){
            establecimiento.setEstado(true);
        }
        establecimientoRepository.save(establecimiento);
    }
    public Establecimiento putEstablecimiento(Establecimiento establecimiento, Long id){
        Establecimiento est = establecimientoRepository.findById(id).get();
        est.setCorreo(establecimiento.getCorreo());
        est.setTelefono(establecimiento.getTelefono());
        est.setRazon_social(establecimiento.getRazon_social());
        est.setRepresentante_legal(establecimiento.getRepresentante_legal());
        est.setSitio_web(establecimiento.getSitio_web());
        est.setRuc(establecimiento.getRuc());
        est.setNombre(establecimiento.getNombre());
        est.setLogo(establecimiento.getLogo());
        est.setEstado(establecimiento.getEstado());
        if(establecimiento.getEstado() == null) {
            est.setEstado(est.getEstado());
        }
            else{
                est.setEstado(est.getEstado());
            }   
        return establecimientoRepository.save(est);
    }

    public void deleteEstablecimiento(Long id){
        establecimientoRepository.deleteById(id);
    }
}

