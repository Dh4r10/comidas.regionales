package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "reserva")
@SQLDelete(sql = "UPDATE reserva SET estado = false WHERE id = ?")
public class Reserva {

    // MESA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroPersonas;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private LocalTime prorroga;
    private Boolean estado;

    @OneToMany (mappedBy = "reserva", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleReserva> detalleReserva;

    // CONSTRUCTOR

    public Reserva() {}

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalTime horaReserva) {
        this.horaReserva = horaReserva;
    }

    public LocalTime getProrroga() {
        return prorroga;
    }

    public void setProrroga(LocalTime prorroga) {
        this.prorroga = prorroga;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<DetalleReserva> getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(List<DetalleReserva> detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", numeroPersonas=" + numeroPersonas +
                ", fechaReserva=" + fechaReserva +
                ", horaReserva=" + horaReserva +
                ", prorroga=" + prorroga +
                ", estado=" + estado +
                ", detalleReserva=" + detalleReserva +
                '}';
    }
}
