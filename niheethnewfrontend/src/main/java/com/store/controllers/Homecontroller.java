package com.store.controllers;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niheeth.niheethbackend.dao.Userdao;
import com.niheeth.niheethbackend.model.User;


@Controller
public class Homecontroller {

	@Autowired
	Userdao userdao;
	@Autowired
	User user;
	@Autowired
	SessionFactory sessionFactory;
	@RequestMapping("/")
	public String getindex()
	{
		return "index";
	}
	@RequestMapping("/login")
	public String getlogin()
	{
		return "login";
	}
	@RequestMapping("/signup")
	public String getsignup()
	{
		return"signup";
	}
	@RequestMapping("/aboutus")
	public String getaboutus()
	{
		return"aboutus";
	}

	@ModelAttribute
	public User returnObject()
	{
		return new User(); 
	}
	 //After clicking submit this page with data is opened and is sent to addus page
	@RequestMapping(value = "/addus", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request)
	{
		System.out.print(user.getCpassword());
		System.out.println(user.getPassword());

		user.setEnabled("true");
		user.setRole("ROLE_USER");

		if (user.getCpassword().equals(user.getPassword()));
		{
			userdao.saveOrUpdate(user);
		}
		
		return "Login";
	}
}
