package com.niheeth.niheethbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niheeth.niheethbackend.model.User;
@Repository
@EnableTransactionManagement
public class Userdaoimpl implements Userdao {
	public Userdaoimpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userdaoimpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	SessionFactory sessionFactory;
	
	public List<User> list() {
		try {
			
			return sessionFactory.getCurrentSession().createQuery("From User",User.class).getResultList();
		}
		catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}

	public User getByEmail(String email) {
		try {
			System.out.println(email);
			
			return sessionFactory.getCurrentSession().createQuery("from User where emailid=:email",User.class).setParameter("email",email).getSingleResult();
			
		}
		catch(Exception e){
			System.out.println("Exception");
			e.printStackTrace();
		return null;}
	}
	@Transactional
	public void saveOrUpdate(User user) {
		try {
			String email=user.getEmailid();
			System.out.println(email);
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			s.saveOrUpdate(user);
			tx.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
	//Method to delete the user object from the Database
	@Transactional
	public void delete(String email) {
		try {
			System.out.println(email);
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			User user=new User();
			user=getByEmail(email);
			System.out.println(user.getUserid());
			s.get(User.class,user.getUserid());
			s.delete(user);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	

}
