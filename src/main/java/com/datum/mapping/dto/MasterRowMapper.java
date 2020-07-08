package com.datum.mapping.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.datum.mapping.model.Master;

public class MasterRowMapper implements RowMapper<Master> {

	@Override
	public Master mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Master master=new Master();
		master.setAccountNo(rs.getLong("account_no"));
		master.setAccountName(rs.getString("account_name"));
		master.setClientCode(rs.getInt("client_code"));
		master.setModifyDate(rs.getDate("modify_date"));
		return master;
	}
	
	
	

}
