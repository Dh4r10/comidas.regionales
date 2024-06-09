package proyecto.grupal.lp.comidas.regionales.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;
import proyecto.grupal.lp.comidas.regionales.Entities.Venta;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Long> {



    List<Venta> findAllByCliente(Cliente cliente);
}
