package com.niheeth.niheethbackend.dao;

import java.util.List;



import com.niheeth.niheethbackend.model.User;

public interface Userdao {

	public List<User> list();
	public User getByEmail(String email);
	public void saveOrUpdate(User user);
	public void delete(String email);
	
	
	
	
}
