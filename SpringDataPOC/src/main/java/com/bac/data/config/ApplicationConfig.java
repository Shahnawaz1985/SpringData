package com.bac.data.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bac.data.dao.ConfigAttributes;


@Configuration
@ComponentScan(basePackages = {"com.bac.data.repositories", "com.bac.data.bean", "com.bac.data.service"})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

	@Resource
	private Environment env;

	@Bean
	@Conditional(MySqlPropertyCondition.class)
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(ConfigAttributes.PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getProperty(ConfigAttributes.PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getProperty(ConfigAttributes.PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getProperty(ConfigAttributes.PROPERTY_NAME_DATABASE_PASSWORD));
		return dataSource;
	}

	
	
}
