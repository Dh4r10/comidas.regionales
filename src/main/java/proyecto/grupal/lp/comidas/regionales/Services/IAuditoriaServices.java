package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Auditoria;

import java.util.List;
import java.util.Optional;

public interface IAuditoriaServices {

    List<Auditoria> getAuditoria();
    Optional<Auditoria> getAuditoriaById(Long id);
    void postAuditoria(Auditoria auditoria);
    Auditoria putAuditoria(Auditoria auditoria,Long id);
    void deleteAuditoria(Long id);

}
