package com.gl.custproject.service;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.gl.custproject.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService 
{	
	private SessionFactory sessionFactory;
	private Session session;
	
	public CustomerServiceImpl(SessionFactory sessionFac) 
	{
		this.sessionFactory=sessionFac;
		
		try 
		{
			//if there is no session already created, it throws an Exception
			session=this.sessionFactory.getCurrentSession();
		}
		catch(HibernateException e) 
		{
			//create/open the session
			session=this.sessionFactory.openSession();
		}
	}

	//spring transactional method-either the method succeeds or rollsback
	
	//Show all Students
	@Override
	@Transactional
	public List<Customer> showAll() 
	{
		List<Customer> custList=session.createQuery("from Customer").list();
		/*for(Customer s:studList) {
			System.out.println(s);
		}*/
		return custList;
	}
	
	//find a student by id->used for editing student record
		@Transactional
		public Customer findById(Integer id)
		{
			Customer cust=session.get(Customer.class,id);
			return cust;		
		}
		
	//Add a student record
	@Transactional
	public void addCustomer(Customer customer) 
	{
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(customer);//save new record and update an existing record
		tr.commit();
	}

	
	//delete a student's record
	@Override
	@Transactional
	public void deleteCustomerRecord(Customer s) {
		Transaction tr=session.beginTransaction();
		session.delete(s);		
		tr.commit();		
	}
}
