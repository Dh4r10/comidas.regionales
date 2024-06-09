package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Insumo;
import proyecto.grupal.lp.comidas.regionales.Repositories.InsumoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IInsumoService;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService implements IInsumoService {
    //Esto esna funcion get
    @Autowired
    private InsumoRepository insumoRepository;
    public List<Insumo> getInsumo(){

        return insumoRepository.findAll();
    }

    public Optional<Insumo> ObtenerInsumo(Long id) {
        return insumoRepository.findById(id);
    }

    public void GuardarInsumo(Insumo insumo) {
        if (insumo.getEstado()==null){
            insumo.setEstado(true);
        }
        insumoRepository.save(insumo);
    }
    public Insumo ActualizarInsumo(Insumo insumo, Long id) {
        Insumo i = insumoRepository.findById(id).get();
        i.setTipoInsumo(insumo.getTipoInsumo());
        i.setEstado(insumo.getEstado());
        i.setUnidadMedida(insumo.getUnidadMedida());
        i.setDescripcion(insumo.getDescripcion());
        i.setStockMaximo(insumo.getStockMaximo());

        if(insumo.getEstado()==null){
            i.setEstado(i.getEstado());
        }
        else{
            i.setEstado(insumo.getEstado());
        }
        return insumoRepository.save(i);
    }
    public void EliminarInsumo(Long id) {
        insumoRepository.deleteById(id);
    }
}
