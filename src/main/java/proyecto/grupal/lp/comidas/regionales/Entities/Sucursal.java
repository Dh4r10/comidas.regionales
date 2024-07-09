package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Entity
@Table(name="sucursal")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@SQLDelete(sql="UPDATE sucursal SET estado=false WHERE id=?")
@Where(clause = "estado = true")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,length=50)
    private String nombre;
    @Column(nullable=false,length=150)
    private String referencia;
    @Column(nullable=false,length=40)
    private String departamento_direccion;
    @Column(nullable=false,length=40)
    private String provincia_direccion;
    @Column(nullable=false,length=40)
    private String distrito_direccion;
    @Column(nullable=false,length=50)
    private String direccion;
    @Column(nullable=false,length=10)
    private String telefono;
    @Column(nullable=false)
    private Boolean estado=true;

    @ManyToOne
    @JoinColumn(name ="id_establecimiento",referencedColumnName = "id" )
    private Establecimiento idEstablecimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Establecimiento getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Establecimiento idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDepartamento_direccion() {
        return departamento_direccion;
    }

    public void setDepartamento_direccion(String departamento_direccion) {
        this.departamento_direccion = departamento_direccion;
    }

    public String getProvincia_direccion() {
        return provincia_direccion;
    }

    public void setProvincia_direccion(String provincia_direccion) {
        this.provincia_direccion = provincia_direccion;
    }

    public String getDistrito_direccion() {
        return distrito_direccion;
    }

    public void setDistrito_direccion(String distrito_direccion) {
        this.distrito_direccion = distrito_direccion;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", referencia='" + referencia + '\'' +
                ", departamento_direccion='" + departamento_direccion + '\'' +
                ", provincia_direccion='" + provincia_direccion + '\'' +
                ", distrito_direccion='" + distrito_direccion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado=" + estado +
                ", idEstablecimiento=" + idEstablecimiento +
                '}';
    }
}
