package com.niheeth.niheethbackend.dao;
import java.util.List;
import com.niheeth.niheethbackend.model.Category;
public interface Categorydao {

	
	
	public List<Category> list();
	public Category get(String name);
	public void saveOrUpdate(Category category);
	public void delete(String name);
	
}
