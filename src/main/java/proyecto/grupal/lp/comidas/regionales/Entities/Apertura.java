package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="apertura")
public class Apertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double monto_inicial ;
    @Column(nullable = false)
    private LocalDate fecha_apertura;
    @Column(nullable = false)
    private LocalDate fecha_cierre;
    @Column(nullable = false)
    private Boolean estado;

    @ManyToOne
    private Caja caja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto_inicial() {
        return monto_inicial;
    }

    public void setMonto_inicial(Double monto_inicial) {
        this.monto_inicial = monto_inicial;
    }

    public LocalDate getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(LocalDate fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(LocalDate fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    @Override
    public String toString() {
        return "Apertura{" +
                "id=" + id +
                ", monto_inicial=" + monto_inicial +
                ", fecha_apertura=" + fecha_apertura +
                ", fecha_cierre=" + fecha_cierre +
                ", estado=" + estado +
                ", caja=" + caja +
                '}';
    }
}
