package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the informacion database table.
 * 
 */
@Entity
@NamedQuery(name="Informacion.findAll", query="SELECT i FROM Informacion i")
public class Informacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idInformacion;

	@Lob
	private String comentario;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	//bi-directional many-to-one association to InformacionHasEstudiante
	@OneToMany(mappedBy="informacion")
	private List<InformacionHasEstudiante> informacionHasEstudiantes;

	public Informacion() {
	}

	public int getIdInformacion() {
		return this.idInformacion;
	}

	public void setIdInformacion(int idInformacion) {
		this.idInformacion = idInformacion;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<InformacionHasEstudiante> getInformacionHasEstudiantes() {
		return this.informacionHasEstudiantes;
	}

	public void setInformacionHasEstudiantes(List<InformacionHasEstudiante> informacionHasEstudiantes) {
		this.informacionHasEstudiantes = informacionHasEstudiantes;
	}

	public InformacionHasEstudiante addInformacionHasEstudiante(InformacionHasEstudiante informacionHasEstudiante) {
		getInformacionHasEstudiantes().add(informacionHasEstudiante);
		informacionHasEstudiante.setInformacion(this);

		return informacionHasEstudiante;
	}

	public InformacionHasEstudiante removeInformacionHasEstudiante(InformacionHasEstudiante informacionHasEstudiante) {
		getInformacionHasEstudiantes().remove(informacionHasEstudiante);
		informacionHasEstudiante.setInformacion(null);

		return informacionHasEstudiante;
	}

}