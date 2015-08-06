/**
 * 
 */
package com.demo.app.init.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author vinay
 *
 */
@Configuration
public class DataSourceConfig {
	@Bean
	public JndiObjectFactoryBean dataSource() {
		JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
		// jndiObjectFB.setJndiName("java:comp/env/jdbc/demoDS");
		jndiObjectFB.setJndiName("java:comp/env/jdbc/demoDS");
		jndiObjectFB.setResourceRef(true);
		jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
		System.out.println("inside datasource - " + jndiObjectFB.getObject());
		return jndiObjectFB;
	}

	@Bean
	public EntityManager entityManager() {
		return entityManagerFactory().getObject().createEntityManager();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setDataSource((DataSource) dataSource().getObject());
		em.setPackagesToScan("com.demo.app.data.model");
		return em;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
	}
}
