package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;
@Entity
@Table(name = "proveedor")
@SQLDelete(sql = "UPDATE proveedor SET estado = false WHERE id = ?")
public class Proveedor {
    //CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruc;
    private String tipoRuc;
    private String razonSocial;
    private String telefono;
    private String correo;
    private Boolean estado;
    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Compra> compra;

    // GETTERS Y SETTERS


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

    public String getTipoRuc() {
        return tipoRuc;
    }

    public void setTipoRuc(String tipoRuc) {
        this.tipoRuc = tipoRuc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Compra> getCompra() {
        return compra;
    }

    public void setCompra(List<Compra> compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", ruc='" + ruc + '\'' +
                ", tipoRuc='" + tipoRuc + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", estado=" + estado +
                ", compra=" + compra +
                '}';
    }

    public Proveedor() {
    }
}
