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
			//getEmployeebyId(session);
			//updateEmployeeById(session);
			//deleteEmployeeById(session);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	private static void deleteEmployeeById(Session session) {
		Employee employee = session.get(Employee.class,2);
		if(employee != null)
		{
			
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
		}
		else
		{
			System.out.println("Employee doesn't exist with provided id..");
		}
		
		
	}

	private static void updateEmployeeById(Session session) {
		Employee employee = session.get(Employee.class,2);
		if(employee != null)
		{
			employee.setSalary(400000.00);
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		}
		else
		{
			System.out.println("Employee doesn't exist with provided id..");
		}
		
	}

	private static void getEmployeebyId(Session session) {
		Employee employee = session.get(Employee.class,2);
		if(employee != null)
		{
			System.out.println(employee);
		}
		else
		{
			System.out.println("Employee doesn't exist with provided id..");
		}
		
	}

	private static void createEmployee(Session session) {
		session.beginTransaction();			
		Integer id =(Integer) session.save(getEmployee());
		System.out.println("Employee id is created: "+id);			
		session.getTransaction().commit();
	}
	
	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Sundar Pichai");
		employee.setEmail("pich@gmail.com");
		employee.setSalary(180000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
