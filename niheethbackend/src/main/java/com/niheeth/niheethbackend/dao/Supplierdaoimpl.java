package com.niheeth.niheethbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niheeth.niheethbackend.model.Supplier;


@Repository
public class Supplierdaoimpl implements Supplierdao {

	
	
	
	public Supplierdaoimpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Supplierdaoimpl() {
		// TODO Auto-generated constructor stub
	}



	@Autowired
	SessionFactory sessionFactory;
	public List<Supplier> list() {
	try {
			
			return sessionFactory.getCurrentSession().createQuery("From Supplier",Supplier.class).getResultList();
		}
		catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}

	public Supplier get(String name) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Supplier where SUPPLIERname=:name",Supplier.class).setParameter("name",name).getSingleResult();
			
		}
		catch(Exception e){
		return null;}
	}

	public void saveOrUpdate(Supplier supplier) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			s.saveOrUpdate(supplier);
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
			Supplier supplier=new Supplier();
			supplier=get(name);
			s.delete(supplier);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
