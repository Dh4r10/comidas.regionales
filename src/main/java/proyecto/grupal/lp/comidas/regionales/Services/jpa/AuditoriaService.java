package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Auditoria;
import proyecto.grupal.lp.comidas.regionales.Repositories.AuditoriaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IAuditoriaServices;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaService implements IAuditoriaServices {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public List<Auditoria> getAuditoria() {
        return auditoriaRepository.findAll();
    }
    public Optional<Auditoria> getAuditoriaById(Long id) {
        return auditoriaRepository.findById(id);
    }

    public void postAuditoria(Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
        if(auditoria.getEstado()==null){}
        auditoria.setEstado(true);

    }

    public Auditoria putAuditoria(Auditoria auditoria,Long id) {
        Auditoria audi = auditoriaRepository.findById(id).get();

        audi.setAccion(auditoria.getAccion());
        audi.setEntidad(auditoria.getEntidad());
        audi.setFecha(auditoria.getFecha());
        audi.setResponsable(auditoria.getResponsable());
        audi.setId_registro(audi.getId_registro());

        if (auditoria.getEstado() == null) {
            audi.setEstado(audi.getEstado());
        } else {
            audi.setEstado(auditoria.getEstado());
        }
        return auditoriaRepository.save(audi);
    }

    public void deleteAuditoria(Long id) {
        auditoriaRepository.deleteById(id);
    }
}
