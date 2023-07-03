package ar.edu.unju.fi.entity;

import java.util.Date;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="IMC")
public class IndiceMasaCorporal {

@Id	
	private Long id;
@Column
	private Date fecha_imc;
@Column
	private String usuario;
@Column
	private String estado;

	public IndiceMasaCorporal() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	
	/*public IndiceMasaCorporal() {
		super();
		//this.usuario = usuarioLogeado;
		this.fecha_imc = new Date();
		
	}*/
	
}