package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "ubicacion")
@SQLDelete(sql = "UPDATE ubicacion SET estado = false WHERE id = ?")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "pasillo_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "FK_UB_PA"), nullable = false)
    private Pasillo pasillo;
    private String estante;
    private String nivel;
    private Boolean estado;
    @OneToMany(mappedBy = "ubicacion", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Insumo> insumo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pasillo getPasillo() {
        return pasillo;
    }

    public void setPasillo(Pasillo pasillo) {
        this.pasillo = pasillo;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Insumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(List<Insumo> insumo) {
        this.insumo = insumo;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "id=" + id +
                ", pasillo=" + pasillo +
                ", estante='" + estante + '\'' +
                ", nivel='" + nivel + '\'' +
                ", estado=" + estado +
                ", insumo=" + insumo +
                '}';
    }

    public Ubicacion() {
    }
}
