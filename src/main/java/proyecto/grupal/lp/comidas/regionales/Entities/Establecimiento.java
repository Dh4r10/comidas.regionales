package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org. hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "establecimiento")
@SQLDelete(sql="UPDATE establecimiento SET estado=false WHERE id=?")
@Where(clause = "estado = true")
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nombre;
    private String ruc;
    private String razon_social;
    private String telefono;
    private String correo;
    @ManyToOne
    private RepresentanteLegal representante_legal;
    private String sitio_web;
    private Boolean estado;
    private String logo;

    /*Esto es para que la relación sea vi direccional, en este caso no lo necesitamos, porque solo
    * requeremimos los datos del establecimiento en la otra tabla*/
  // @OneToMany(mappedBy = "idEstablecimiento", fetch = FetchType.LAZY, orphanRemoval = true)
   //private List<Sucursal> sucursales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }


    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public RepresentanteLegal getRepresentante_legal() {
        return representante_legal;
    }

    public void setRepresentante_legal(RepresentanteLegal representante_legal) {
        this.representante_legal = representante_legal;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Establecimiento() {
    }

    @Override
    public String toString() {
        return "Establecimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ruc='" + ruc + '\'' +
                ", razon_social='" + razon_social + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", representante_legal=" + representante_legal +
                ", sitio_web='" + sitio_web + '\'' +
                ", estado=" + estado +
                ", logo='" + logo + '\'' +
                '}';
    }
}
