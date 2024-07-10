package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Dto.DetalleMesaGetDto;
import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDto;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetalleMesaRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.PedidoRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.VentaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleMesaService;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleMesaService implements IDetalleMesaService {

    @Autowired
    private DetalleMesaRepository detalleMesaRepository;

    @Autowired
    private IDetallePedidoService detallePedidoService;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<DetalleMesa> getAllDetallePedidoMesas() {
        return detalleMesaRepository.findAll();
    }

    public List<DetalleMesaGetDto> getPedidoPorMesa(Long idMesa) {
        List<DetalleMesaGetDto> detalleMesaGetDtos = new ArrayList<>();
        List<Pedido> pedidoPorMesa = pedidoRepository.pedidoPorMesaById(idMesa);

        for ( Pedido value : pedidoPorMesa) {
            boolean validarVenta = ventaRepository.existsByPedidoId(value.getId());

            if (!validarVenta) {
                DetalleMesaGetDto dto = new DetalleMesaGetDto();
                dto.setPedidoId(value.getId());
                dto.setFechaPedido(value.getFecha());
                dto.setPendiente(validarVenta);
                detalleMesaGetDtos.add(dto);
            }
        }

        return detalleMesaGetDtos;
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
