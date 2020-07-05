package com.datum.mapping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datum.mapping.dao.CustomerDaoImpl;
import com.datum.mapping.dto.CustomerDto;
import com.datum.mapping.model.Customer;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired	
	private CustomerDaoImpl customerDaoImpl;

	
	@GetMapping("/getCustomers")
	public List<CustomerDto> find(){
		return customerDaoImpl.find();
		
	}
	@PostMapping("/postCustomers")
	public ResponseEntity<Void> save(@RequestBody Customer customer) {
		logger.info("customer name is:{}",customer.getFirstName());
		customerDaoImpl.save(customer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer/{clientCode}")
	public ResponseEntity<String> update(@PathVariable("clientCode") int clientCode,@RequestBody Customer customer){
		
		customerDaoImpl.update(clientCode,customer);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	

}
