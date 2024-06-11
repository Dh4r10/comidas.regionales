package proyecto.grupal.lp.comidas.regionales.Entities;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@SQLDelete(sql = "UPDATE usuario SET estado = false WHERE id = ?")
public class Usuario implements UserDetails{

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//CAMPOS 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn (name="tipo_usuario_id", referencedColumnName = "id", foreignKey =@ForeignKey(name = "FK_TU_U"), nullable=true)
    private TipoUsuario tipoUsuario;
    
	
    private UUID idPublico;
    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String direccion;
    private String correo;
    private String username;
    private String password;
    private LocalDate ultimoIngresoFecha;
    private LocalTime ultimoIngresoHora;
    private Boolean online;
    private Boolean estado;
    
	//GETTERS Y SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getIdPublico() {
		return idPublico;
	}

	public void setIdPublico(UUID idPublico) {
		this.idPublico = idPublico;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getUltimoIngresoFecha() {
		return ultimoIngresoFecha;
	}

	public void setUltimoIngresoFecha(LocalDate ultimoIngresoFecha) {
		this.ultimoIngresoFecha = ultimoIngresoFecha;
	}

	public LocalTime getUltimoIngresoHora() {
		return ultimoIngresoHora;
	}

	public void setUltimoIngresoHora(LocalTime ultimoIngresoHora) {
		this.ultimoIngresoHora = ultimoIngresoHora;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	@Override
	public String toString() {
		return "Usuario [tipoUsuario=" + tipoUsuario + ", id=" + id + ", idPublico=" + idPublico + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", username="
				+ username + ", password=" + password + ", ultimoIngresoFecha=" + ultimoIngresoFecha
				+ ", ultimoIngresoHora=" + ultimoIngresoHora + ", online=" + online + ", estado=" + estado + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		return List.of(new SimpleGrantedAuthority(tipoUsuario.getNombre()));
	}
	
	 //CONSTRUCTORES

		public Usuario() {
			super();
		}
		
    
}
