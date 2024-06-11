package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Sucursal sucursal;
    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Responsable{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", sucursal=" + sucursal +
                ", estado=" + estado +
                '}';
    }
}
