package com.bac.data.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bac.data.dao.ConfigAttributes;
import com.bac.data.repositories.ContactRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages= {"com.bac.data.repositories"})
public class JPAConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
		entityManagerFactoryBean.setDataSource(dataSource);	
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setPackagesToScan(ConfigAttributes.PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());
		entityManagerFactoryBean.setPersistenceUnitName("jpa_contact_service_px");
		entityManagerFactoryBean.setSharedCacheMode(SharedCacheMode.UNSPECIFIED);
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean.getObject();
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(ConfigAttributes.PROPERTY_NAME_HIBERNATE_DIALECT,
				ConfigAttributes.PROPERTY_NAME_HIBERNATE_DIALECT_VAL);
		properties.put(ConfigAttributes.PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				ConfigAttributes.PROPERTY_NAME_HIBERNATE_SHOW_SQL_VAL);
		properties.put(ConfigAttributes.PROPERTY_HIBERNATE_MAX_FETCH_DEPTH,
				ConfigAttributes.PROPERTY_HIBERNATE_MAX_FETCH_DEPTH_VAL);
		properties.put(ConfigAttributes.PROPERTY_HIBERNATE_JDBC_FETCH_SIZE,
				ConfigAttributes.PROPERTY_HIBERNATE_JDBC_FETCH_SIZE_VAL);
		properties.put(ConfigAttributes.PROPERTY_HIBERNATE_JDBC_BATCH_SIZE,
				ConfigAttributes.PROPERTY_HIBERNATE_JDBC_BATCH_SIZE_VAL);
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
	}
	
	@Bean
	public ContactRepository contactRepository() {
		JpaRepositoryFactory  factory = new JpaRepositoryFactory(entityManagerFactory().createEntityManager());
		ContactRepository repository = factory.getRepository(ContactRepository.class);
		return repository;
	}

}
