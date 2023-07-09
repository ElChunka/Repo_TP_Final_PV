package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "testimonios")
public class Testimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testimonio_id")
	private Long id;

	@Column(name = "testimonio_fecha")
	private LocalDate fecha;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	@NotBlank(message = "El comentario no puede estar vacío")
	@Size(min = 30, max = 5000, message = "Debe escribir un texto con entre 30 y 5000 caracteres")
	@Column(name = "testimonio_comentario", columnDefinition = "LONGTEXT")
	private String comentario;
	

	public Testimonio() {
		super();
	}

	public Testimonio(LocalDate fecha, Usuario usuario, String comentario) {
        super();
        this.fecha = fecha;
        this.usuario = usuario;
        this.comentario = comentario;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
}
