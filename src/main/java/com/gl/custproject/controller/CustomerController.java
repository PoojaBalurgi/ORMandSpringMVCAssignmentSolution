package com.gl.custproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gl.custproject.entity.Customer;
import com.gl.custproject.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	//spring managed
	@Autowired
	private CustomerService customerService;

	//get list of all students
	@RequestMapping("/list")
	public String showAllCustomers(Model model) {
		List<Customer> customerList = customerService.showAll();
		model.addAttribute("customers", customerList);
		return "Customers";
	}
	
	//Add/Edit student record form
	@RequestMapping("/addOrUpdateRecord")
	public String addoredit(@RequestParam("customerId") Integer id, Model model) 
	{
		if (id != 0) {
			Customer cust = customerService.findById(id);
			model.addAttribute("customer", cust);
		}
		else
		{
			Customer cust=new Customer();			
			model.addAttribute("customer",cust);
		}
		return "CustomerForm";
	}


	//save student record
	@RequestMapping("/save")
	public String save(@RequestParam("id")Integer Id, 
			@RequestParam("fName") String firstName, 
			@RequestParam("lName") String lastName,
			@RequestParam("email") String email) 
	{
		Customer s=new Customer();
		if (Id != 0) 
		{
			s = customerService.findById(Id);
			s.setFirstName(firstName);
			s.setLastName(lastName);
			s.setEmail(email);
		} 
		else 
		{
			// if id does not exist, create it
			s = new Customer(firstName, lastName, email);

		}
		// addStudent() consists save & update functions
		customerService.addCustomer(s);
		return "redirect:list";
	}
	
	//delete a student's record
	@RequestMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("customerId") Integer id) 
	{
		Customer s=null;
		if (id !=0) 
		{
			s=customerService.findById(id);
			customerService.deleteCustomerRecord(s);
		}
		else
		{
			System.out.println("Customer not Exist");
		}
		return "redirect:list";
	}

}
