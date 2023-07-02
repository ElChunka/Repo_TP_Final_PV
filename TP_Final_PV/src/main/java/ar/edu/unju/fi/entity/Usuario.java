package ar.edu.unju.fi.entity;

import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNacimiento;
	private Long telefono;
	private String sexo;
	private Double estatura;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellido, String email, LocalDate fechaNacimiento, Long telefono, String sexo,
			Double estatura) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estatura = estatura;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", telefono=" + telefono + ", sexo=" + sexo + ", estatura=" + estatura + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	
}
