package com.dao;

import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Customer;
import com.util.ConnectionUtil;

public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<Customer> findAll(){

		String sql = "SELECT * FROM CUSTOMER";

		List<Customer> customers  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(Customer.class));

		return customers;
	}
	
	public int findTotalCustomer(){

		String sql = "SELECT COUNT(*) FROM CUSTOMER";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}
	
	public void saveOrUpdate(Customer customer) {
	    if (customer.getCust_id() < 0) {
	        // update
	        String sql = "UPDATE customer SET cust_id=?, cust_name=?, age=?, "
	                    + " WHERE cust_id=?";
	        jdbcTemplate.update(sql, customer.getCust_id(), customer.getCust_name(),
	                customer.getAge(),customer.getCust_id());
	    } else {
	        // insert
	        String sql = "INSERT INTO customer (cust_id,cust_name,age)"
	                    + " VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, customer.getCust_id(), customer.getCust_name(),
	                customer.getAge());
	    }
	 
	}
	
	public void delete(int cust_id) {
	    String sql = "DELETE FROM customer WHERE cust_id=?";
	    jdbcTemplate.update(sql, cust_id);
	    
	    System.out.println("Successfully deleted");
	}
	

}
