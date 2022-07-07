package com.gl.custproject.service;
import java.util.List;
import com.gl.custproject.entity.Customer;


public interface CustomerService {

	public List<Customer> showAll();
	public Customer findById(Integer id);
	public void addCustomer(Customer customer);
	public void deleteCustomerRecord(Customer s);
}
