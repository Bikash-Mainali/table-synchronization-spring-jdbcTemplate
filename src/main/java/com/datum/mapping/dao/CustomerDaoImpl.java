package com.datum.mapping.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.datum.mapping.dto.CustomerDto;
import com.datum.mapping.model.Customer;

@Service
public class CustomerDaoImpl implements CustomerDao{
	
	
	//could not we get columns directly from table (eg customer_table) rather than from entity (eg. Customer)??

	@Override
	public List<CustomerDto> find() {
		Session session = com.datum.mapping.util.CustomerSchema.getSession();
		Transaction tr=session.beginTransaction();
		String sql="SELECT * FROM customer";
		List<CustomerDto> customers = (List<CustomerDto>)
				session
				.createQuery(
				    "select " +
				    "   c.clientCode as clientCode, " +
				    "   c.firstName as firstName " +
				    "from Customer c ")
				.unwrap(org.hibernate.query.Query.class).setResultTransformer( new ResultTransformer() {
			        @Override
			        public Object transformTuple(
			                Object[] tuple,
			                String[] aliases) {
			            return new CustomerDto(
			                ((Number) tuple[0]).intValue(),
			                (tuple[1]).toString());
			        }
			 
			        @Override
			        public List transformList(List tuples) {
			            return tuples;
			        }
			    }
			)
			.getResultList();
		return customers;
	}

	@Override
	public void save(Customer customer) {
		Session session = com.datum.mapping.util.CustomerSchema.getSession();
		Transaction tr=session.beginTransaction();
	    session.save(customer);	
		tr.commit();
	}

	@Override
	public void update(int clientCode, Customer customer) {
		
		Session session = com.datum.mapping.util.CustomerSchema.getSession();
		Transaction tr=session.beginTransaction();
		System.out.println("............."+clientCode);
		System.out.println("................."+customer.getFirstName());
	    String sql="update customer  set first_name=:fName where client_code="+clientCode+"";	
		session.createQuery(sql).setParameter("fName",customer.getFirstName()).executeUpdate();
		tr.commit();
	}
	
	
	

}
