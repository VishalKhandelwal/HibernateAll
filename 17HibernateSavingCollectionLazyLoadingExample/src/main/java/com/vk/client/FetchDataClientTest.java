package com.vk.client;



import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.vk.entities.Employee;

import com.vk.util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	Employee employee = session.get(Employee.class,1);
	    	System.out.println(employee);
	    	if(employee != null)
	    	{
	    		employee.getAddressList().forEach(System.out::println);
	    	}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	
}