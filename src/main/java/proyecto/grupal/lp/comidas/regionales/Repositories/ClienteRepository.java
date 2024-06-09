package proyecto.grupal.lp.comidas.regionales.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {



}