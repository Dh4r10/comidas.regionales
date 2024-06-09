package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Compra;
import proyecto.grupal.lp.comidas.regionales.Repositories.CompraRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ICompraService;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements ICompraService {
    //Esto esna funcion get
    @Autowired
    private CompraRepository compraRepository;
    public List<Compra> getCompra(){

        return compraRepository.findAll();
    }

    public Optional<Compra> ObtenerCompra(Long id) {
        return compraRepository.findById(id);
    }

    public void GuardarCompra(Compra compra) {
        if (compra.getEstado()==null){
            compra.setEstado(true);
        }
        compraRepository.save(compra);
    }
    public Compra ActualizarCompra(Compra compra, Long id) {
        Compra c = compraRepository.findById(id).get();
        c.setCodigoRecibo(compra.getCodigoRecibo());
        c.setFechaEmision(compra.getFechaEmision());
        c.setFechaVencimiento(compra.getFechaVencimiento());
        c.setDescripcion(compra.getDescripcion());

        if(compra.getEstado()==null){
            c.setEstado(c.getEstado());
        }
        else{
            c.setEstado(compra.getEstado());
        }
        return compraRepository.save(c);
    }
    public void EliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}
