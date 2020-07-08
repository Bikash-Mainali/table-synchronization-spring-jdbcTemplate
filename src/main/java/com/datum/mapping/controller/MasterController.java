
package com.datum.mapping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datum.mapping.dao.CustomerDaoImpl;
import com.datum.mapping.dao.MasterDaoImpl;
import com.datum.mapping.model.Customer;
import com.datum.mapping.model.Master;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MasterController {
	Logger logger = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private MasterDaoImpl masterDaoImpl;

	@GetMapping("/getMaster")
	public ResponseEntity<List<Master>> find() {
		return new ResponseEntity<>(masterDaoImpl.find(),HttpStatus.OK);
	}
}
