package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grado database table.
 * 
 */
@Entity
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGrado;

	private int anio;

	private String nombre;

	//bi-directional many-to-one association to GradoHasEstudiante
	@OneToMany(mappedBy="grado")
	private List<GradoHasEstudiante> gradoHasEstudiantes;

	//bi-directional many-to-one association to InformacionHasEstudiante
	@OneToMany(mappedBy="grado")
	private List<InformacionHasEstudiante> informacionHasEstudiantes;

	public Grado() {
	}

	public int getIdGrado() {
		return this.idGrado;
	}

	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<GradoHasEstudiante> getGradoHasEstudiantes() {
		return this.gradoHasEstudiantes;
	}

	public void setGradoHasEstudiantes(List<GradoHasEstudiante> gradoHasEstudiantes) {
		this.gradoHasEstudiantes = gradoHasEstudiantes;
	}

	public GradoHasEstudiante addGradoHasEstudiante(GradoHasEstudiante gradoHasEstudiante) {
		getGradoHasEstudiantes().add(gradoHasEstudiante);
		gradoHasEstudiante.setGrado(this);

		return gradoHasEstudiante;
	}

	public GradoHasEstudiante removeGradoHasEstudiante(GradoHasEstudiante gradoHasEstudiante) {
		getGradoHasEstudiantes().remove(gradoHasEstudiante);
		gradoHasEstudiante.setGrado(null);

		return gradoHasEstudiante;
	}

	public List<InformacionHasEstudiante> getInformacionHasEstudiantes() {
		return this.informacionHasEstudiantes;
	}

	public void setInformacionHasEstudiantes(List<InformacionHasEstudiante> informacionHasEstudiantes) {
		this.informacionHasEstudiantes = informacionHasEstudiantes;
	}

	public InformacionHasEstudiante addInformacionHasEstudiante(InformacionHasEstudiante informacionHasEstudiante) {
		getInformacionHasEstudiantes().add(informacionHasEstudiante);
		informacionHasEstudiante.setGrado(this);

		return informacionHasEstudiante;
	}

	public InformacionHasEstudiante removeInformacionHasEstudiante(InformacionHasEstudiante informacionHasEstudiante) {
		getInformacionHasEstudiantes().remove(informacionHasEstudiante);
		informacionHasEstudiante.setGrado(null);

		return informacionHasEstudiante;
	}

}