package com.vk.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.vk.entities.Employee;
import com.vk.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createEmployee(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getEmployee());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
		
	}
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Barry Bingel");
		employee.setEmail("barry.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
