package com.niheeth.niheethbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niheeth.niheethbackend.dao.Userdao;
import com.niheeth.niheethbackend.model.User;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	static Userdao userdao;
	@Autowired
	static User user;
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		userdao=(Userdao)context.getBean("userdao");
		user=(User)context.getBean("user");
	}
	@Test
	public void test()//update
	{
		user.setUserid(100);
		user.setUsername("user5");
		user.setPassword("abcdefg");
		user.setEmailid("mniheeth123@gmail.com");
		user.setFirstname("venkatNiheeth");
		user.setLastname("mamidala");
		user.setCpassword("abcdefg");
		user.setRole("ROLE_USER");
		userdao.saveOrUpdate(user);
	}
	
	@Test
	public void addUser()//saving
	{
		
		user.setUsername("user4");
		user.setPassword("abcdefg");
		user.setEmailid("mniheeth121@gmail.com");
		user.setFirstname("venkatNiheeth");
		user.setLastname("mamidala");
		user.setCpassword("abcdefg");
		user.setRole("ROLE_USER");
		userdao.saveOrUpdate(user);
	}
	@Test
	public void deleteUser()
	{
		userdao.delete("mniheeth1200@gmail.com");
		assertEquals("deleted","deleted");
	}
	
	}
	
	

