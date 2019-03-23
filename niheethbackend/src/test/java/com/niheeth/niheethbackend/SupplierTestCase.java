package com.niheeth.niheethbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niheeth.niheethbackend.dao.Categorydao;
import com.niheeth.niheethbackend.dao.Productdao;
import com.niheeth.niheethbackend.dao.Supplierdao;
import com.niheeth.niheethbackend.dao.Userdao;
import com.niheeth.niheethbackend.model.Category;
import com.niheeth.niheethbackend.model.Product;
import com.niheeth.niheethbackend.model.Supplier;
import com.niheeth.niheethbackend.model.User;

public class SupplierTestCase {

	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	static Supplierdao supplierdao;
	@Autowired
	static Supplier supplier;
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierdao=(Supplierdao)context.getBean("supplierdao");
		supplier=(Supplier)context.getBean("supplier");
	}
	/*@Test
	
	public void saveorupdate() {
		
		
		supplier.setSuppliername("Niheeth");
		supplierdao.saveOrUpdate(supplier);
	}*/
	@Test
	public void delete() {
		supplierdao.delete("Rajkamal");
		assertEquals("deleted","deleted");
	}


}
