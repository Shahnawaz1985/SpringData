package com.bac.data.dao;

public interface ConfigAttributes {
	
	 String PROPERTY_NAME_DATABASE_DRIVER = "mysql_jdbc.driverClassName";
	 String PROPERTY_NAME_DATABASE_PASSWORD = "mysql_jdbc.password";
	 String PROPERTY_NAME_DATABASE_URL = "mysql_jdbc.url";
	 String PROPERTY_NAME_DATABASE_USERNAME = "mysql_jdbc.username";
	 
	 String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.bac.data.bean";
	 
	 String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	 String PROPERTY_NAME_HIBERNATE_DIALECT_VAL = "org.hibernate.dialect.MySQL5Dialect";
	 String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";	 
	 String PROPERTY_NAME_HIBERNATE_SHOW_SQL_VAL = "true";
	 String PROPERTY_HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
	 String PROPERTY_HIBERNATE_MAX_FETCH_DEPTH_VAL = "3";
	 String PROPERTY_HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
	 String PROPERTY_HIBERNATE_JDBC_FETCH_SIZE_VAL = "50";
	 String PROPERTY_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	 String PROPERTY_HIBERNATE_JDBC_BATCH_SIZE_VAL = "5";



}
