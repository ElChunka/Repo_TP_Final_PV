package ar.edu.unju.fi.entity;

import jakarta.persistence.Entity;

@Entity
public class PesoIdeal {

	private int edad;
	private float peso;
	private float estatura;
	
	public PesoIdeal(long id, int edad, float peso, float estatura) {
		super();
		this.edad = edad;
		this.peso = peso;
		this.estatura = estatura;
	}



	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	
	
	
}
