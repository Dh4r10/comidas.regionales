package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetallePedidoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> getAllDetallePedidos() {
        return detallePedidoRepository.findAll();
    }

    public Optional<DetallePedido> getDetallePedidoById(Long id) {
        return detallePedidoRepository.findById(id);
    }

    public DetallePedido postDetallePedido(DetallePedido request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        detallePedidoRepository.save(request);
        return request;
    }

    public DetallePedido putDetallePedido(DetallePedido request, Long id) {
        DetallePedido detallePedido = detallePedidoRepository.findById(id).get();

        detallePedido.setPedido(request.getPedido());
        detallePedido.setProducto(request.getProducto());
        detallePedido.setDescripcion(request.getDescripcion());
        detallePedido.setCantidad(request.getCantidad());

        if (request.getEstado() == null) {
            detallePedido.setEstado(detallePedido.getEstado());
        } else {
            detallePedido.setEstado(request.getEstado());
        }

        return detallePedidoRepository.save(detallePedido);

    }

    public void deleteDetallePedido(Long id) {
        detallePedidoRepository.deleteById(id);
    }

}
