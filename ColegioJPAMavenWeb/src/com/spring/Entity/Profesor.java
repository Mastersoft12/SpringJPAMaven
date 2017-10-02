package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProfesor;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha_baja;

	//bi-directional many-to-one association to GradoHasEstudiante
	@OneToMany(mappedBy="profesor")
	private List<GradoHasEstudiante> gradoHasEstudiantes;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	public Profesor() {
	}

	public int getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha_baja() {
		return this.fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public List<GradoHasEstudiante> getGradoHasEstudiantes() {
		return this.gradoHasEstudiantes;
	}

	public void setGradoHasEstudiantes(List<GradoHasEstudiante> gradoHasEstudiantes) {
		this.gradoHasEstudiantes = gradoHasEstudiantes;
	}

	public GradoHasEstudiante addGradoHasEstudiante(GradoHasEstudiante gradoHasEstudiante) {
		getGradoHasEstudiantes().add(gradoHasEstudiante);
		gradoHasEstudiante.setProfesor(this);

		return gradoHasEstudiante;
	}

	public GradoHasEstudiante removeGradoHasEstudiante(GradoHasEstudiante gradoHasEstudiante) {
		getGradoHasEstudiantes().remove(gradoHasEstudiante);
		gradoHasEstudiante.setProfesor(null);

		return gradoHasEstudiante;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}