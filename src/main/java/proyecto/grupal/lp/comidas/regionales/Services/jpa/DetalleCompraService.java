package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleCompra;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetalleCompraRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleCompraService;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraService implements IDetalleCompraService {
    //Esto esna funcion get
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;
    public List<DetalleCompra> getDetalleCompra(){

        return detalleCompraRepository.findAll();
    }

    public Optional<DetalleCompra> ObtenerDetalleCompra(Long id) {
        return detalleCompraRepository.findById(id);
    }

    public void GuardarDetalleCompra(DetalleCompra detalleCompra) {
        if (detalleCompra.getEstado()==null){
            detalleCompra.setEstado(true);
        }
        detalleCompraRepository.save(detalleCompra);
    }
    public DetalleCompra ActualizarDetalleCompra(DetalleCompra detalleCompra, Long id) {
        DetalleCompra dc = detalleCompraRepository.findById(id).get();


        if(detalleCompra.getEstado()==null){
            dc.setEstado(dc.getEstado());
        }
        else{
            dc.setEstado(detalleCompra.getEstado());
        }
        return detalleCompraRepository.save(dc);
    }
    public void EliminarDetalleCompra(Long id) {
        detalleCompraRepository.deleteById(id);
    }
}
