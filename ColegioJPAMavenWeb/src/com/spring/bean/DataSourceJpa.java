package com.spring.bean;

import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.stereotype.Component;

@Component("dataSourceJpa")
public class DataSourceJpa {

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException{
		JndiObjectFactoryBean jndiObjetFB = new JndiObjectFactoryBean();
		jndiObjetFB.setJndiName("dsColegio");
		jndiObjetFB.afterPropertiesSet();
		return (DataSource)jndiObjetFB.getObject();
	}
	

	@Bean
	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean() throws IllegalArgumentException, NamingException{
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] {"com.spring.Entity"});
		JpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);    
		localContainerEntityManagerFactoryBean.setPersistenceUnitName("ColegioJPAMavenWeb");
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(initJpaProperties());
		localContainerEntityManagerFactoryBean.setLoadTimeWeaver(new ReflectiveLoadTimeWeaver());
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean;
	}
	
	private final Map<String, ?> initJpaProperties() {
        final Map<String, Object> ret = new HashMap<>();
        // Incluir cualquier propiedad Jpa que este soportada por la base de datos y la implementacion Jpa utilizada
        ret.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
        ret.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
        return ret;
    }

	

}

