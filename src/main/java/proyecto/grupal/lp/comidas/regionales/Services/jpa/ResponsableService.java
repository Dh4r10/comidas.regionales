package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Apertura;
import proyecto.grupal.lp.comidas.regionales.Entities.Responsable;
import proyecto.grupal.lp.comidas.regionales.Repositories.ResponsableRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IResponsableServices;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ResponsableService implements IResponsableServices{
    @Autowired
    private ResponsableRepository responsableRepository;

    public List<Responsable> getResponsable() {
        return responsableRepository.findAll();
    }

    public Optional<Responsable> getResponsableId(Long id) {
        return responsableRepository.findById(id);
    }

    public void postResponsable(Responsable responsable) {
        responsableRepository.save(responsable);
    }

    public Responsable putResponsable(Responsable responsable,Long id) {
        Responsable oldResponsable = responsableRepository.findById(id).get();

        oldResponsable.setSucursal(responsable.getSucursal());
        oldResponsable.setUsuario(responsable.getUsuario());
        if (responsable.getEstado() == null) {
            oldResponsable.setEstado(oldResponsable.getEstado());
        } else {
            oldResponsable.setEstado(responsable.getEstado());

        }
        return responsableRepository.save(oldResponsable);
    }

    public void delteResponsable(Long id) {
        responsableRepository.deleteById(id);
    }
}
