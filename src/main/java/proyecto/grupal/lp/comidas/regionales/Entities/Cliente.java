package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@SQLDelete(sql = "UPDATE cliente SET estado = false WHERE id=?")
@SQLRestriction("estado = true")
public class Cliente {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dniRuc;
    private String nombreRazonsocial;

    private String telefono;
    private  Boolean estado;

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    private List<Venta> ventas= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDniRuc() {
        return dniRuc;
    }

    public void setDniRuc(String dniRuc) {
        this.dniRuc = dniRuc;
    }

    public String getNombreRazonsocial() {
        return nombreRazonsocial;
    }

    public void setNombreRazonsocial(String nombreRazonsocial) {
        this.nombreRazonsocial = nombreRazonsocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente() {
    }

    public Cliente(Long id, String dniRuc, String nombreRazonsocial, String telefono, Boolean estado) {
        this.id = id;
        this.dniRuc = dniRuc;
        this.nombreRazonsocial = nombreRazonsocial;
        this.telefono = telefono;
        this.estado = estado;
    }
}
