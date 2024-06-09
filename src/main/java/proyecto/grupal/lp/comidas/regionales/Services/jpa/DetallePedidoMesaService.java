package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedidoMesa;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetallePedidoMesaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoMesaService;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoMesaService implements IDetallePedidoMesaService {

    @Autowired
    private DetallePedidoMesaRepository detallePedidoMesaRepository;

    @Autowired
    private IDetallePedidoService detallePedidoService;

    public List<DetallePedidoMesa> getAllDetallePedidoMesas() {
        return detallePedidoMesaRepository.findAll();
    }

    public Optional<DetallePedidoMesa> getDetallePedidoMesaById(Long id) {
        return detallePedidoMesaRepository.findById(id);
    }

    public void postDetallePedidoMesa(DetallePedidoMesa request) {

        DetallePedido detallePedido = detallePedidoService.postDetallePedido(request.getDetallePedido());

        request.getDetallePedido().setId(detallePedido.getId());

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        detallePedidoMesaRepository.save(request);
    }

    public DetallePedidoMesa putDetallePedidoMesa(DetallePedidoMesa request, Long id) {
        DetallePedidoMesa detallePedidoMesa = detallePedidoMesaRepository.findById(id).get();

        detallePedidoMesa.setMesa(request.getMesa());

        if (request.getEstado() == null) {
            detallePedidoMesa.setEstado(detallePedidoMesa.getEstado());
        } else {
            detallePedidoMesa.setEstado(request.getEstado());
        }

        return detallePedidoMesaRepository.save(detallePedidoMesa);
    }

    public void deleteDetallePedidoMesa(Long id) {
        detallePedidoMesaRepository.deleteById(id);
    }

}
