package ar.edu.unju.fi.entity;

import java.util.Date;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Component
@Entity
@Table(name="indiceMasaCorporal")
public class IndiceMasaCorporal {

	@Id
	@Column(name = "imc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotBlank(message="Debe de haber una fecha de registro")
	@Column(name = "fecha_imc")
	private Date fecha_imc;
	
	//@NotBlank(message="No puede estar vacio")
	@Column(name = "usuario_imc")
	private String usuario;
	
	//@NotBlank(message="Tiene que haber un estado")
	@Column(name = "estado_imc")
	private String estado;

	public IndiceMasaCorporal(Long id, Date fecha_imc, String usuario, String estado) {
		super();
		this.id = id;
		this.fecha_imc = fecha_imc;
		this.usuario = usuario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_imc() {
		return fecha_imc;
	}

	public void setFehca_imc(Date fecha_imc) {
		this.fecha_imc = fecha_imc;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String isEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "IndiceMasaCorporal [id=" + id + ", fecha_imc=" + fecha_imc + ", usuario=" + usuario + ", estado="
				+ estado + "]";
	}
	
	public IndiceMasaCorporal() {
		super();
		/*/this.usuario = usuarioLogeado;
		this.fecha_imc = new Date();*/
		
	}
	
}