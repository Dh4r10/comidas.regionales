package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "salon")
@SQLDelete(sql = "UPDATE salon SET estado = false WHERE id = ?")
public class Salon {

    // CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="sucursal_id",referencedColumnName = "id" )
    private Sucursal sucursal;

    private Integer piso;
    private String nombre;
    private Integer aforo;
    private Boolean estado;

    @OneToMany (mappedBy = "salon", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Area> area;

    // CONSTRUCTOR

    public Salon() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

        public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }


    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Area> getArea() {
        return area;
    }

    public void setArea(List<Area> area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "id=" + id +
                ", sucursal=" + sucursal +
                ", piso=" + piso +
                ", nombre='" + nombre + '\'' +
                ", aforo=" + aforo +
                ", estado=" + estado +
                ", area=" + area +
                '}';
    }
}
