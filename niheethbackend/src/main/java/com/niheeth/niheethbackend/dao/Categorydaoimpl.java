package com.niheeth.niheethbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niheeth.niheethbackend.model.Category;
import com.niheeth.niheethbackend.model.User;
@Repository
public class Categorydaoimpl implements Categorydao {

	public Categorydaoimpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Categorydaoimpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Category> list() {
try {
			
			return sessionFactory.getCurrentSession().createQuery("From Category",Category.class).getResultList();
		}
		catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}
	@Autowired
	SessionFactory sessionFactory;

	public Category get(String name) {
		try {
			System.out.println("inside get");
			return sessionFactory.getCurrentSession().createQuery("from Category where categoryname=:name",Category.class).setParameter("name",name).getSingleResult();
			
		}
		catch(Exception e){
		return null;}
	}

	public void saveOrUpdate(Category category) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			s.saveOrUpdate(category);
			tx.commit();
			s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	}
	@Transactional
	public void delete(String name) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			System.out.println("Here");
			Category category=new Category();
			category=get(name);
			
			s.delete(category);
			tx.commit();
			System.out.println("closed");
			s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
