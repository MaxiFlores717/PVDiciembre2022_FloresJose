package ar.edu.unju.edm.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	private Long DNI;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@NotNull
	private LocalDate FechaDeNacimiento;
	@NotEmpty
	private String password;
	@Column(name = "tipo_usuario")
	@NotEmpty
	private String tipoUsuario;

	public Long getDNI() {
		return DNI;
	}

	public void setDNI(Long dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return FechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		FechaDeNacimiento = fechaDeNacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
