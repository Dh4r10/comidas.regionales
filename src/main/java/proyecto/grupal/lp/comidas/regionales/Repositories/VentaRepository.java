package proyecto.grupal.lp.comidas.regionales.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;
import proyecto.grupal.lp.comidas.regionales.Entities.Venta;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Long> {

    @Query("SELECT COUNT(v) > 0 FROM Venta v WHERE v.pedido.id = :id")
    boolean existsByPedidoId(@Param("id") Long id);

    List<Venta> findAllByCliente(Cliente cliente);
}
