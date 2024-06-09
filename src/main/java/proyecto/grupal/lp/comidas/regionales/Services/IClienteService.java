package proyecto.grupal.lp.comidas.regionales.Services;



import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;

import java.util.List;

public interface IClienteService {


    Cliente registrarCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente, Long id);
    Cliente obtenerCliente(Long id);
    void eliminarCliente(Long id);
    List<Cliente> verTodosClientes();
}
