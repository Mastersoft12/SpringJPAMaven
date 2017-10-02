package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the informacion_has_estudiante database table.
 * 
 */
@Entity
@Table(name="informacion_has_estudiante")
@NamedQuery(name="InformacionHasEstudiante.findAll", query="SELECT i FROM InformacionHasEstudiante i")
public class InformacionHasEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InformacionHasEstudiantePK id;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	private Estudiante estudiante;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	//bi-directional many-to-one association to Informacion
	@ManyToOne
	private Informacion informacion;

	public InformacionHasEstudiante() {
	}

	public InformacionHasEstudiantePK getId() {
		return this.id;
	}

	public void setId(InformacionHasEstudiantePK id) {
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

	public Informacion getInformacion() {
		return this.informacion;
	}

	public void setInformacion(Informacion informacion) {
		this.informacion = informacion;
	}

}