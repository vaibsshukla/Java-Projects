package com.b3ds.fhir.metadata.config;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement()
@ComponentScan(value={"com.b3ds.fhir.metadata.config"})
public class ApplicationContext 
{

	private final ResourceBundle rb = ResourceBundle.getBundle("db");
	
	 @Bean
	 public LocalSessionFactoryBean sessionFactory() 
	 {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.b3ds.fhir.metadata.models" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
	 }
	
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource bds=new BasicDataSource();		
		bds.setDriverClassName(rb.getString("MYSQL_DB_DRIVER_CLASS"));
		bds.setUrl(rb.getString("MYSQL_DB_URL"));
		bds.setUsername(rb.getString("MYSQL_DB_USERNAME"));
		bds.setPassword(rb.getString("MYSQL_DB_PASSWORD"));
		return bds;					
	}
	
	private Properties hibernateProperties() 
	{
        Properties properties = new Properties();
        properties.put("hibernate.dialect", org.hibernate.dialect.MySQL8Dialect.class.getName());
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;        
    }
	
	 @Bean
	 @Autowired
	 public HibernateTransactionManager transactionManager(SessionFactory s) 
	 {
	    HibernateTransactionManager txManager = new HibernateTransactionManager();
	    txManager.setSessionFactory(s);
	    return txManager;
	  }
	
	
}
