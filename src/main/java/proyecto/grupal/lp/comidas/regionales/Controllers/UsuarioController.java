package proyecto.grupal.lp.comidas.regionales.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import proyecto.grupal.lp.comidas.regionales.Entities.Usuario;
import proyecto.grupal.lp.comidas.regionales.Services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioService.getAllUsuario();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping("/tipo-usuario/{id}")
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {

        return new ResponseEntity<>(usuarioService.postUsuario(usuario,id), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Usuario putUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.putUsuario(usuario, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "Usuario con id=" + id + " eliminado correctamente";
    }
}
