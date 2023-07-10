package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ing_id")
	private Long id;
	
	@Column(name="ing_nombre")
	@NotBlank(message="Debe ingresar un nombre para el ingrediente")
	private String nombre;
	
	@ManyToMany(mappedBy="ingredientes")
	private List<Receta> recetas;

	public Ingrediente() {
	}
	
	public Ingrediente(Long id, String nombre, List<Receta> recetas) {
		this.id = id;
		this.nombre = nombre;
		this.recetas = recetas;
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

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
	
}
