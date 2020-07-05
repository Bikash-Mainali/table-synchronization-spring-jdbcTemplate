package com.datum.mapping.dao;

import java.util.List;

import com.datum.mapping.dto.CustomerDto;
import com.datum.mapping.model.Customer;

public interface CustomerDao {
	public List<CustomerDto> find();
	public void save(Customer customer);
	public void update(int clientCode,Customer customer);
}
