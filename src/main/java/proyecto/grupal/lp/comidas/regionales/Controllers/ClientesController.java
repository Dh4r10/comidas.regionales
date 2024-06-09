package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;
import proyecto.grupal.lp.comidas.regionales.Services.IClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    @Autowired
    private IClienteService clienteService;
    @PostMapping("/create")
    public ResponseEntity<?>  registrarCliente(@RequestBody Cliente cliente){

        return new ResponseEntity<>(clienteService.registrarCliente(cliente), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<?> getAllCLientes(){
        return ResponseEntity.ok(clienteService.verTodosClientes());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>actualizarCliente(@PathVariable Long id,@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.actualizarCliente(cliente,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCLientes(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.obtenerCliente(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok().build();
    }





}
