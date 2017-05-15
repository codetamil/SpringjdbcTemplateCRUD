package com.revature.JdbcTemplate;

import com.dao.CustomerDao;
import com.model.Customer;

public class TestCustomerDao {
	
	public static void main(String args[])
	{
		CustomerDao customer= new CustomerDao();
		
		System.out.println(customer.findAll());
		
		System.out.println(customer.findTotalCustomer());
		
		Customer cc= new Customer();
		
		cc.setCust_id(26);
		cc.setCust_name("Ranjana");
		cc.setAge(33);
		
	customer.saveOrUpdate(cc);
	customer.delete(25);
	}

}
