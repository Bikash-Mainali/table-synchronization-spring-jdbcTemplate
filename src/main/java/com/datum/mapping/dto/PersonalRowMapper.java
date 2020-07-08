package com.datum.mapping.dto;

import com.datum.mapping.model.Customer;
import com.datum.mapping.model.PersonalInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalRowMapper implements RowMapper<PersonalInfo> {

    @Override
    public PersonalInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonalInfo personalInfo=new PersonalInfo();
        personalInfo.setCustomerId(rs.getInt("customer_id"));
        personalInfo.setFirstName(rs.getString("first_name"));
        personalInfo.setLastName(rs.getString("last_name"));
        return personalInfo;
    }

}
