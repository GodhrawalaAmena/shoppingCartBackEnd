package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class applicationContextConfig {
	
	@Bean(name = "dataSource")
	public DataSource getH2DataSource (){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource ();
        
		try
		{
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/shoppingcartdb");
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
			
			}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return dataSource;
		
	}
	
    private Properties getHibernateProperties() {
    	
    	Properties properties = new Properties();
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	properties.put("hibernate.show_sql", "true");
    	return properties;		
    	
    	
    }
	
    @Autowired
    @Bean(name = sessionFactory)
    public SessionFactory getSessionFactory (DataSource dataSource){
    	
    }
}
