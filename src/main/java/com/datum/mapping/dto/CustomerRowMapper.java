package com.datum.mapping.dto;

import com.datum.mapping.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer=new Customer();
		customer.setClientCode(rs.getInt("client_code"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setLastName(rs.getString("last_name"));
		customer.setFatherName(rs.getString("father_name"));
		customer.setModifyDate(rs.getDate("modify_date"));
		return customer;
	}

}
