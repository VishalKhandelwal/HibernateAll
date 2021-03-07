package com.vk.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		//creating standard service registry builder
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		
		//Hibernate setting which is equivalent to hibernate.cfg.xml's properties
		Map<String, String> dbSettings = new HashMap<>();
		dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
		dbSettings.put(Environment.USER, "root");
		dbSettings.put(Environment.PASS, "123456");
		dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		
		//apply database settings
		registryBuilder.applySettings(dbSettings);
		//Creating Registry
		standardServiceRegistry = registryBuilder.build();
		//Creating MetaDataSources
		MetadataSources sources = new MetadataSources(standardServiceRegistry);
		//Creating MetaData
		Metadata metadata = sources.getMetadataBuilder().build();
		//Creating Session Factory
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory; 
	}
}
