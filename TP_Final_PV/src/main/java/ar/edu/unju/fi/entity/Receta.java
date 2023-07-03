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
	
	@Column(name="rec_categoría")
	private String categoría;
	
	@Column(name="rec_preparación")
	private String preparación;
	
	@Lob
	@Column(name="rec_imagenes")
	private byte[] imagen;
	
	@ManyToMany
	@JoinTable(name="recetas_ingredientes",
	joinColumns=@JoinColumn(name="rec_id"),
	inverseJoinColumns=@JoinColumn(name="ing_id"))
	private List<Ingrediente> ingredientes;

	public Receta() {
	}

	public Receta(Long id, String nombre, String categoría, String preparación, byte[] imagen, List<Ingrediente> ingredientes) {
		this.id = id;
		this.nombre = nombre;
		this.categoría = categoría;
		this.preparación = preparación;
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

	public String getCategoría() {
		return categoría;
	}

	public void setCategoría(String categoría) {
		this.categoría = categoría;
	}

	public String getPreparación() {
		return preparación;
	}

	public void setPreparación(String preparación) {
		this.preparación = preparación;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
}
