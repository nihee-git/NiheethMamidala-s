package com.niheeth.niheethbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niheeth.niheethbackend.model.Product;

public interface Productdao {

	public List<Product> list();
	public Product get(String name);
	public void saveOrUpdate(Product product);
	public void delete(String name);
	
	
	
	
}
