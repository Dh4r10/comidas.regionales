package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Repositories.PedidoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IPedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    public void postPedido(Pedido request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        pedidoRepository.save(request);
    }

    public Pedido putPedido(Pedido request, Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();

        pedido.setFecha(request.getFecha());
        pedido.setTipoPedido(request.getTipoPedido());

        if (request.getEstado() == null) {
            pedido.setEstado(pedido.getEstado());
        } else {
            pedido.setEstado(request.getEstado());
        }

        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }

}
