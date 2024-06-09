package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.Date;

@Entity
@Table(name="auditoria")
@SQLDelete(sql="UPDATE auditoria SET estado=false WHERE id=?")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long registro_id;
    @Column(nullable = false,length = 15)
    private String accion;
    private String campos_modificados;
    @Column(nullable = false,length = 60)
    private String responsable;
    @Column(nullable = false,length = 30)
    private String entidad;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_registro() {
        return registro_id;
    }

    public void setId_registro(Long id_registro) {
        this.registro_id = id_registro;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getCampos_modificados() {
        return campos_modificados;
    }

    public void setCampos_modificados(String campos_modificados) {
        this.campos_modificados = campos_modificados;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Auditoria{" +
                "id=" + id +
                ", registro_id=" + registro_id +
                ", accion='" + accion + '\'' +
                ", campos_modificados='" + campos_modificados + '\'' +
                ", responsable='" + responsable + '\'' +
                ", entidad='" + entidad + '\'' +
                ", fecha=" + fecha +
                ", estado=" + estado +
                '}';
    }
}
