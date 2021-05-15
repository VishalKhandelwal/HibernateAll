package com.vk.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.vk.entities.Address;
import com.vk.entities.Employee;
import com.vk.util.HibernateUtil;

public class SaveDataClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
	    	Employee employee= new Employee();
			employee.setEmployeeName("Barry");
			employee.setEmail("barry.cs2019@gmail.com");
			employee.setSalary(50000.00);
			employee.setDoj(new Date());
			
			Address address1 = new Address();
			address1.setCity("Chennai");
			address1.setPincode(9087727L);
			address1.setState("Tamilnadu");
			address1.setStreet("Park Street");
			
			Address address2 = new Address();
			address2.setCity("Pube");
			address2.setPincode(9000027L);
			address2.setState("MH");
			address2.setStreet("XYZ Street");
			
			List<Address> addressList = Arrays.asList(address1,address2);			
			employee.setAddressList(addressList);
			session.persist(employee);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}