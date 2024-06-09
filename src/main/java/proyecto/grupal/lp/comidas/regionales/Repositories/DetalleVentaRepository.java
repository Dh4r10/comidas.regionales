package proyecto.grupal.lp.comidas.regionales.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleVenta;
import proyecto.grupal.lp.comidas.regionales.Entities.Venta;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {

    List<DetalleVenta> findAllByVenta(Venta venta);
}
