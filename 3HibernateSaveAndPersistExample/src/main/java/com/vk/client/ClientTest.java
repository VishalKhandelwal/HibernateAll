package com.vk.client;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.vk.entities.Employee;
import com.vk.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = getEmployee();
			session.beginTransaction();
			
			/*
	    	 persist() -> This method is used to save an entity/object into database and return a void.
	    	  It will throw an exception if an entity already exists in the database.
	    	 */
			
			//session.persist(employee);
			
			
			/*
	    	 save() -> This method is used to save an entity/object into database and return generated primarykey.
	    	  It will throw an exception if an entity already exists in the database.
	    	 */
			
			//saveOrUpdate()->This method is used to either save or update an entity in the database.
			Integer id =(Integer) session.save(employee);
			System.out.println("id is: "+id);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Nisha");
		employee.setEmail("Nisha@gmail.com");
		employee.setSalary(80000.00);
		employee.setDoj(LocalDate.now());
		return employee;
	}
}
