package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the informacion_has_estudiante database table.
 * 
 */
@Embeddable
public class InformacionHasEstudiantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int informacion_idInformacion;

	@Column(insertable=false, updatable=false)
	private int estudiante_idEstudiante;

	public InformacionHasEstudiantePK() {
	}
	public int getInformacion_idInformacion() {
		return this.informacion_idInformacion;
	}
	public void setInformacion_idInformacion(int informacion_idInformacion) {
		this.informacion_idInformacion = informacion_idInformacion;
	}
	public int getEstudiante_idEstudiante() {
		return this.estudiante_idEstudiante;
	}
	public void setEstudiante_idEstudiante(int estudiante_idEstudiante) {
		this.estudiante_idEstudiante = estudiante_idEstudiante;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InformacionHasEstudiantePK)) {
			return false;
		}
		InformacionHasEstudiantePK castOther = (InformacionHasEstudiantePK)other;
		return 
			(this.informacion_idInformacion == castOther.informacion_idInformacion)
			&& (this.estudiante_idEstudiante == castOther.estudiante_idEstudiante);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.informacion_idInformacion;
		hash = hash * prime + this.estudiante_idEstudiante;
		
		return hash;
	}
}