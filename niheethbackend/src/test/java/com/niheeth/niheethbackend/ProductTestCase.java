package com.niheeth.niheethbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niheeth.niheethbackend.dao.Productdao;
import com.niheeth.niheethbackend.model.Product;

public class ProductTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	static Productdao productdao;
	@Autowired
	static Product product;
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		productdao=(Productdao)context.getBean("productdao");
		product=(Product)context.getBean("product");}
								
	@Test
	public void saveorupdate() {
		product.setPrice(1000);
		product.setProductname("oppo");
		product.setQuantity(100);
		product.setProductid(11);
		product.setDescription("oppo is russia based mobile company,its new model has 13mp camera,4gb ram,pubg play mode ");
		productdao.saveOrUpdate(product);
	}
	@Test
	public void delete() {
		productdao.delete("vivo");
		assertEquals("deleted","deleted");
	}

}
