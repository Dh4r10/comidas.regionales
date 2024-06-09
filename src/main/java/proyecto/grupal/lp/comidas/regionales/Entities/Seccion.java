package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "seccion")
@SQLDelete(sql = "UPDATE seccion SET estado = false WHERE id = ?")
public class Seccion {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="carta_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_SE_CA"), nullable = false)
    private Carta carta;

    private String nombre;
    private Boolean estado;

    @OneToMany (mappedBy = "seccion", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Categoria> categoria;

    // CONSTRUCTOR

    public Seccion() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Seccion{" +
                "id=" + id +
                ", carta=" + carta +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", categoria=" + categoria +
                '}';
    }
}
