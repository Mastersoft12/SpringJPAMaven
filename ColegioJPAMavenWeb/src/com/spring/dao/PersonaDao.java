package com.spring.dao;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.Entity.Persona;
import com.spring.bean.DataSourceJpa;

@Component("personaDao")
public class PersonaDao implements IPersonaDao {
	
	@Autowired
    @Qualifier("dataSourceJpa")
	private DataSourceJpa dataSource;
	
	private EntityManagerFactory emf;	

	@Override
	public Persona buscarPerosna() {
		Persona person = new Persona();
		if(null != dataSource){
			try {
				emf = dataSource.containerEntityManagerFactoryBean().nativeEntityManagerFactory;
				person = emf.createEntityManager().find(Persona.class, 1);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return person;
	}

	public DataSourceJpa getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSourceJpa dataSource) {
		this.dataSource = dataSource;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	

}
