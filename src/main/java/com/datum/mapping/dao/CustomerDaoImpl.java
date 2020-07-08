package com.datum.mapping.dao;

import com.datum.mapping.dto.CustomerRowMapper;
import com.datum.mapping.dto.PersonalRowMapper;
import com.datum.mapping.model.Customer;
import com.datum.mapping.model.PersonalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerDaoImpl implements CustomerDao {

    JdbcTemplate customerJdbcTemplate;

    public CustomerDaoImpl(DataSource customerDataSource) {
        customerJdbcTemplate = new JdbcTemplate(customerDataSource);
    }

    Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    LocalDate date = LocalDate.now();

    @Override
    @Transactional(readOnly = true)
    public List<String> find() {
        return customerJdbcTemplate.queryForList("SELECT first_name FROM customer_schema.customer", String.class);

    }

    @Override
    public void save(Customer customer) {
        logger.info("data inserting..........");

        // customer table
        customerJdbcTemplate.update(
                "INSERT INTO customer.customer (client_code, first_name, last_name, father_name,modify_date) VALUES (?, ?, ?, ?,?)",
                customer.getClientCode(), customer.getFirstName(), customer.getLastName(), customer.getFatherName(),
                date);

        // personal_info table
        customerJdbcTemplate.update("insert into customer.personal_info (customer_id,first_name,last_name) values(?,?,?)",
                customer.getClientCode(), customer.getFirstName(), customer.getLastName());

    }

    @Override
    public List<Customer> findAll() {
        logger.info("data selecting..........");
        return customerJdbcTemplate.query("select * from customer.customer", new CustomerRowMapper());
    }

    @Override
    public void update(int clientCode, Customer customer) {
        customerJdbcTemplate.update("update customer.customer set first_name='" + customer.getFirstName() + "', last_name='"
                + customer.getLastName() + "',father_name='" + customer.getFatherName() + "',modify_date='"
                + date + "' where client_code='" + clientCode + "'");

        String pSql = "select * from customer.personal_info where customer_id='" + clientCode + "'";
        List<PersonalInfo> personalInfos = customerJdbcTemplate.query(pSql, new PersonalRowMapper());

        if (!personalInfos.get(0).getFirstName().equals(customer.getFirstName()) && !personalInfos.get(0).getLastName().equals(customer.getLastName())) {
            customerJdbcTemplate.update("update customer.personal_info set first_name='" + customer.getFirstName() + "',last_name='"
                    + customer.getLastName() + "' where customer_id='" + clientCode + "'");
        }

        if (!personalInfos.get(0).getFirstName().equals(customer.getFirstName()) && personalInfos.get(0).getLastName().equals(customer.getLastName())) {
            customerJdbcTemplate.update("update customer.personal_info set first_name='" + customer.getFirstName() + "' where customer_id='" + clientCode + "'");
        }

        if (personalInfos.get(0).getFirstName().equals(customer.getFirstName()) && !personalInfos.get(0).getLastName().equals(customer.getLastName())) {
            customerJdbcTemplate.update("update customer.personal_info set first_name='" + customer.getLastName() + "' where customer_id='" + clientCode + "'");
        }
        logger.info("tables updated");
    }
}
