package com.niheeth.niheethbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niheeth.niheethbackend.dao.Categorydao;
import com.niheeth.niheethbackend.dao.Categorydaoimpl;
import com.niheeth.niheethbackend.dao.Productdao;
import com.niheeth.niheethbackend.dao.Productdaoimpl;
import com.niheeth.niheethbackend.dao.Supplierdao;
import com.niheeth.niheethbackend.dao.Supplierdaoimpl;
import com.niheeth.niheethbackend.dao.Userdao;
import com.niheeth.niheethbackend.dao.Userdaoimpl;
import com.niheeth.niheethbackend.model.Category;
import com.niheeth.niheethbackend.model.Product;
import com.niheeth.niheethbackend.model.Supplier;
import com.niheeth.niheethbackend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationContextConfig {
	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/niheethprj");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("Datasource");
		return datasource;
	}
	
	private Properties getHibernateProperties()
	{
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.current_session_context_class","thread");
		System.out.println("Hibernate Properties");
		return prop;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory  getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
	
		System.out.println("Session Factory");
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction Manager");
		return transactionManager;
	}
	@Autowired
	@Bean("userdao")
	public Userdao getUserDao(SessionFactory sessionFactory)
	{
		return new Userdaoimpl();
	}
	@Autowired
	@Bean("user")
	public User getUser(SessionFactory sessionFactory)
	{
		return new User();
	}
	@Autowired
	@Bean("productdao")
	public Productdao getProductDao(SessionFactory sessionFactory)
	{
		return new Productdaoimpl();
	}
	@Autowired
	@Bean("product")
	public Product getProduct(SessionFactory sessionFactory)
	{
		return new Product();
	}
	@Autowired
	@Bean("supplierdao")
	public Supplierdao getSupplierDao(SessionFactory sessionFactory)
	{
		return new Supplierdaoimpl();
	}
	@Autowired
	@Bean("supplier")
	public Supplier getSupplier(SessionFactory sessionFactory)
	{
		return new Supplier();
	}
	@Autowired
	@Bean("categorydao")
	public Categorydao getCategoryDao(SessionFactory sessionFactory)
	{
		return new Categorydaoimpl();
	}
	@Bean("category")
	public Category getCategory(SessionFactory sessionFactory)
	{
		return new Category();
	}
	
}
