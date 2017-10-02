package com.spring.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the grado_has_estudiante database table.
 * 
 */
@Embeddable
public class GradoHasEstudiantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int grado_idGrado;

	@Column(insertable=false, updatable=false)
	private int estudiante_idEstudiante;

	public GradoHasEstudiantePK() {
	}
	public int getGrado_idGrado() {
		return this.grado_idGrado;
	}
	public void setGrado_idGrado(int grado_idGrado) {
		this.grado_idGrado = grado_idGrado;
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
		if (!(other instanceof GradoHasEstudiantePK)) {
			return false;
		}
		GradoHasEstudiantePK castOther = (GradoHasEstudiantePK)other;
		return 
			(this.grado_idGrado == castOther.grado_idGrado)
			&& (this.estudiante_idEstudiante == castOther.estudiante_idEstudiante);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.grado_idGrado;
		hash = hash * prime + this.estudiante_idEstudiante;
		
		return hash;
	}
}