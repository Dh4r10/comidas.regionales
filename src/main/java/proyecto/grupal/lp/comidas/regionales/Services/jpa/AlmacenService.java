package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Almacen;
import proyecto.grupal.lp.comidas.regionales.Repositories.AlmacenRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IAlmacenService;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService implements IAlmacenService {
    //Esto esna funcion get
    @Autowired
    private AlmacenRepository almacenRepository;
    public List<Almacen> getAlmacen(){

        return almacenRepository.findAll();
    }

    public Optional<Almacen> ObtenerAlmacen(Long id) {
        return almacenRepository.findById(id);
    }

    public void GuardarAlmacen(Almacen almacen) {
        if (almacen.getEstado()==null){
            almacen.setEstado(true);
        }
        almacenRepository.save(almacen);
    }
    public Almacen ActualizarAlmacen(Almacen almacen, Long id) {
        Almacen a = almacenRepository.findById(id).get();
        a.setNombre(almacen.getNombre());
        a.setEstado(almacen.getEstado());

        if(almacen.getEstado()==null){
            a.setEstado(a.getEstado());
        }
        else{
            a.setEstado(almacen.getEstado());
        }
        return almacenRepository.save(a);
    }
    public void EliminarAlmacen(Long id) {
        almacenRepository.deleteById(id);
    }
}
