
package com.datum.mapping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.datum.mapping.dto.MasterRowMapper;
import com.datum.mapping.model.Master;

import javax.sql.DataSource;

@Service
public class MasterDaoImpl implements MasterDao {

	JdbcTemplate masterJdbcTemplate;

	public MasterDaoImpl(DataSource masterDataSource) {
		masterJdbcTemplate=new JdbcTemplate(masterDataSource);
	}

	String sql1 = "";
	String sql2 = "";

	@Override
	public List<Master> find() {
			sql1 = "select * from customer_schema.customer";
			return masterJdbcTemplate.query(sql1, new MasterRowMapper());
		}
		
}
