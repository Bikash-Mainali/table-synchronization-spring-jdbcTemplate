package com.datum.mapping.dao;

import java.util.List;

import com.datum.mapping.model.Customer;

public interface CustomerDao {
	public List<String> find();
	 public void save(Customer customer); 
	 public List<Customer> findAll();
	 public void update(int clientCode,Customer customer);
}
