package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;
import proyecto.grupal.lp.comidas.regionales.Repositories.ClienteRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ClienteService;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente registrarCliente(Cliente cliente) {

        Cliente clienteSv= new Cliente();
        clienteSv.setEstado(true);
        clienteSv.setDniRuc(cliente.getDniRuc());
        clienteSv.setNombreRazonsocial(cliente.getNombreRazonsocial());
        clienteSv.setTelefono(cliente.getTelefono());

        return clienteRepository.save(clienteSv);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente, Long id) {
        Cliente clienteBD= clienteRepository.findById(id).orElseThrow();
        clienteBD.setTelefono(cliente.getTelefono());
        clienteBD.setNombreRazonsocial(cliente.getNombreRazonsocial());
        return clienteRepository.save(clienteBD);
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> verTodosClientes() {

        return clienteRepository.findAll();
    }
}
