package com.niheeth.niheethbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niheeth.niheethbackend.model.Category;
import com.niheeth.niheethbackend.model.Product;
@Repository
public class Productdaoimpl implements Productdao {

	

	

	public Productdaoimpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Productdaoimpl() {
		// TODO Auto-generated constructor stub
	}
	public List<Product> list() {
try {
			
			return sessionFactory.getCurrentSession().createQuery("From Product",Product.class).getResultList();
		}
		catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}
	@Autowired
	SessionFactory sessionFactory;
	

	public Product get(String name) {
		try {
			System.out.println("inside get");
			return sessionFactory.getCurrentSession().createQuery("from Product where productname=:name",Product.class).setParameter("name",name).getSingleResult();
			
		}
		catch(Exception e){
		return null;}
	}

	public void saveOrUpdate(Product product) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			s.saveOrUpdate(product);
			tx.commit();
			s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	}

	public void delete(String name) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			System.out.println("Here");
			Product product=new Product();
			product=get(name);
			System.out.println(product.getProductname());
			s.delete(product);
			tx.commit();
			System.out.println("closed");
			//s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
