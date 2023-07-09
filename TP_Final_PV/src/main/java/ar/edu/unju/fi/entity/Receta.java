package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rec_id")
	private Long id;
	
	@Column(name="rec_nombre")
	private String nombre;
	
	@Column(name="rec_categoria")
	private String categoria;
	
	@Column(name="rec_preparacion")
	private String preparacion;

	@Column(name="rec_imagenes")
	private String imagen;
	
	@ManyToMany
	@JoinTable(name="recetas_ingredientes",
	joinColumns=@JoinColumn(name="rec_id"),
	inverseJoinColumns=@JoinColumn(name="ing_id"))
	private List<Ingrediente> ingredientes;

	public Receta() {
	}

	
	
	public Receta(Long id, String nombre, String categoria, String preparacion, String imagen,
			List<Ingrediente> ingredientes) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.preparacion = preparacion;
		this.imagen = imagen;
		this.ingredientes = ingredientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
}
