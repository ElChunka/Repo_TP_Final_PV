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

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ing_id")
	private Long id;
	
	@Column(name="ing_nombre")
	private String Nombre;
	
	@ManyToMany(mappedBy="ingredientes")
	private List<Receta> recetas;
}
