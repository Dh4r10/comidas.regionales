package proyecto.grupal.lp.comidas.regionales.Controllers;
import proyecto.grupal.lp.comidas.regionales.Entities.TipoUsuario;
import proyecto.grupal.lp.comidas.regionales.Services.ITipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    private ITipoUsuarioService tipoUsuarioService;

    @GetMapping
    public List<TipoUsuario> getAllTipoUsuario() {
        return tipoUsuarioService.getAllTipoUsuario();
    }

    @GetMapping("/{id}")
    public Optional<TipoUsuario> getTipoUsuarioById(@PathVariable Long id) {
        return tipoUsuarioService.getTipoUsuarioById(id);
    }

    @PostMapping
    public TipoUsuario postTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        tipoUsuarioService.postTipoUsuario(tipoUsuario);
        return tipoUsuario;
    }

    @PutMapping("/{id}")
    public TipoUsuario putTipoUsuario(@PathVariable Long id, @RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.putTipoUsuario(tipoUsuario, id);
    }

    @DeleteMapping("/{id}")
    public String deleteTipoUsuario(@PathVariable Long id) {
        tipoUsuarioService.deleteTipoUsuario(id);
        return "TipoUsuario con id=" + id + " eliminado correctamente";
    }
}
