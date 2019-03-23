package com.niheeth.niheethbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niheeth.niheethbackend.dao.Categorydao;
import com.niheeth.niheethbackend.model.Category;

public class CategoryTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	static Categorydao categorydao;
	@Autowired
	static Category category;
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		categorydao=(Categorydao)context.getBean("categorydao");
		category=(Category)context.getBean("category");
	}
	@Test
	public void test() {
	
		
		category.setCategoryname("earphones");
		categorydao.saveOrUpdate(category);
		
		
	}
@Test
	public void delete() {
		categorydao.delete("earphones");
		assertEquals("deleted","deleted");
	}

}
