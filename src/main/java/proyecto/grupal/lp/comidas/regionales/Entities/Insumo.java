package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "insumo")
@SQLDelete(sql = "UPDATE insumo SET estado = false WHERE id = ?")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "ubicacion_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "FK_IN_UB"), nullable = false)
    private Ubicacion ubicacion;
    private String tipoInsumo;
    private String nombre;
    private String unidadMedida;
    private String descripcion;
    private Integer stockMaximo;
    private Boolean estado;
    @OneToMany(mappedBy = "insumo", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleCompra> detalleCompra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "id=" + id +
                ", ubicacion=" + ubicacion +
                ", tipoInsumo='" + tipoInsumo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stockMaximo=" + stockMaximo +
                ", estado=" + estado +
                ", detalleCompra=" + detalleCompra +
                '}';
    }

    public Insumo() {
    }
}
