package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetalleMesaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleMesaService;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleMesaService implements IDetalleMesaService {

    @Autowired
    private DetalleMesaRepository detalleMesaRepository;

    @Autowired
    private IDetallePedidoService detallePedidoService;

    public List<DetalleMesa> getAllDetallePedidoMesas() {
        return detalleMesaRepository.findAll();
    }

    public Optional<DetalleMesa> getDetallePedidoMesaById(Long id) {
        return detalleMesaRepository.findById(id);
    }

    public void postDetallePedidoMesa(DetalleMesa request) {

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        detalleMesaRepository.save(request);
    }

    public DetalleMesa putDetallePedidoMesa(DetalleMesa request, Long id) {
        DetalleMesa detalleMesa = detalleMesaRepository.findById(id).get();

        detalleMesa.setPedido(request.getPedido());
        detalleMesa.setMesa(request.getMesa());

        if (request.getEstado() == null) {
            detalleMesa.setEstado(detalleMesa.getEstado());
        } else {
            detalleMesa.setEstado(request.getEstado());
        }

        return detalleMesaRepository.save(detalleMesa);
    }

    public void deleteDetallePedidoMesa(Long id) {
        detalleMesaRepository.deleteById(id);
    }

}
