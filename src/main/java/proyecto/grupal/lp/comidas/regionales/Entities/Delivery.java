package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "delivery")
@SQLDelete(sql = "UPDATE delivery SET estado = false WHERE id = ?")
public class Delivery {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
	@JoinColumn(name="pedido_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DE_PE"), nullable = false, unique = true
    )
    private Pedido pedido;

    private String direccion;
    private String numeroContacto;
    private Boolean estado;

    // CONSTRUCTOR

    public Delivery() {}

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", direccion='" + direccion + '\'' +
                ", numeroContacto='" + numeroContacto + '\'' +
                ", estado=" + estado +
                '}';
    }
}
