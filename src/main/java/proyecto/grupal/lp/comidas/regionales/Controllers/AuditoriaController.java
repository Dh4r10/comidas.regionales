package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Auditoria;
import proyecto.grupal.lp.comidas.regionales.Services.IAuditoriaServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auditoria")
public class AuditoriaController {

    @Autowired
    private IAuditoriaServices auditoriaServices;

    @GetMapping
    public List<Auditoria> getAuditorias(){
        return auditoriaServices.getAuditoria();
    }
    @GetMapping("/{id}")
    public Optional<Auditoria> getAuditoriaById(@PathVariable Long id){
        return auditoriaServices.getAuditoriaById(id);
    }
    @PostMapping
    public Auditoria postAuditoria(@RequestBody Auditoria auditoria){
        auditoriaServices.postAuditoria(auditoria);
        return auditoria;
    }

    @PutMapping("/{id}")
    public Auditoria putAuditoria(@PathVariable Long id, @RequestBody Auditoria auditoria){
        return auditoriaServices.putAuditoria(auditoria,id);
    }

    @DeleteMapping("/{id}")
    public String deleteAuditoria(@PathVariable Long id){
        auditoriaServices.deleteAuditoria(id);
        return "Auditoria removida la tabla "+id+" com sucesso!";
    }
}
