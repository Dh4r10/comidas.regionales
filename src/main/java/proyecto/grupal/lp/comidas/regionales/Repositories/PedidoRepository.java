package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value = "SELECT P.* FROM pedido AS P INNER JOIN detalle_mesa DM ON P.id = DM.pedido_id INNER JOIN mesa M ON DM.mesa_id = M.id WHERE DM.mesa_id = :id AND P.estado = true", nativeQuery = true)
    List<Pedido> pedidoPorMesaById(@Param("id") Long id);

    @Query(value = "SELECT * FROM pedido WHERE pedido.tipo_pedido = :tipoPedido AND pedido.id = :id", nativeQuery = true)
    Optional<Pedido> pedidoSalonById(@Param("tipoPedido") String tipoPedido, @Param("id") Long id);
}
