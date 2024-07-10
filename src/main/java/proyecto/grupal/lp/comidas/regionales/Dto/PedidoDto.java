package proyecto.grupal.lp.comidas.regionales.Dto;

import java.time.LocalDate;

public class PedidoDto {
    private Long id;
    private LocalDate fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
