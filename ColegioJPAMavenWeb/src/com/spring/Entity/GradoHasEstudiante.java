package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grado_has_estudiante database table.
 * 
 */
@Entity
@Table(name="grado_has_estudiante")
@NamedQuery(name="GradoHasEstudiante.findAll", query="SELECT g FROM GradoHasEstudiante g")
public class GradoHasEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GradoHasEstudiantePK id;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	private Estudiante estudiante;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	private Profesor profesor;

	public GradoHasEstudiante() {
	}

	public GradoHasEstudiantePK getId() {
		return this.id;
	}

	public void setId(GradoHasEstudiantePK id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}