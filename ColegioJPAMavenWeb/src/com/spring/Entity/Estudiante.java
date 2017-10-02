package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEstudiante;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha_baja;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	//bi-directional many-to-one association to GradoHasEstudiante
	@OneToMany(mappedBy="estudiante")
	private List<GradoHasEstudiante> gradoHasEstudiantes;

	//bi-directional many-to-one association to InformacionHasEstudiante
	@OneToMany(mappedBy="estudiante")
	private List<InformacionHasEstudiante> informacionHasEstudiantes;

	public Estudiante() {
	}

	public int getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
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

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<GradoHasEstudiante> getGradoHasEstudiantes() {
		return this.gradoHasEstudiantes;
	}

	public void setGradoHasEstudiantes(List<GradoHasEstudiante> gradoHasEstudiantes) {
		this.gradoHasEstudiantes = gradoHasEstudiantes;
	}

	public GradoHasEstudiante addGradoHasEstudiante(GradoHasEstudiante gradoHasEstudiante) {
		getGradoHasEstudiantes().add(gradoHasEstudiante);
		gradoHasEstudiante.setEstudiante(this);

		return gradoHasEstudiante;
	}

	public GradoHasEstudiante removeGradoHasEstudiante(GradoHasEstudiante gradoHasEstudiante) {
		getGradoHasEstudiantes().remove(gradoHasEstudiante);
		gradoHasEstudiante.setEstudiante(null);

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
		informacionHasEstudiante.setEstudiante(this);

		return informacionHasEstudiante;
	}

	public InformacionHasEstudiante removeInformacionHasEstudiante(InformacionHasEstudiante informacionHasEstudiante) {
		getInformacionHasEstudiantes().remove(informacionHasEstudiante);
		informacionHasEstudiante.setEstudiante(null);

		return informacionHasEstudiante;
	}

}