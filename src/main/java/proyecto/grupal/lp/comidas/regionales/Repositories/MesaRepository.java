package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Entities.Mesa;

import java.util.Set;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {


    @Modifying
    @Query(value = "UPDATE Mesa set ocupado = false WHERE id IN :ids")
    int updateMesaOcupada(@Param("ids") Set<Long> idsMesas);

}
