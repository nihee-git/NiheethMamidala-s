package com.niheeth.niheethbackend.dao;

import java.util.List;
import com.niheeth.niheethbackend.model.Supplier;
public interface Supplierdao {
	
	public List<Supplier> list();
	public Supplier get(String name);
	public void saveOrUpdate(Supplier supplier);
	public void delete(String name);
	
}
