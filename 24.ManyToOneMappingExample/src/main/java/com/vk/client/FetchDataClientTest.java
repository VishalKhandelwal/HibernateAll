package com.vk.client;



import org.hibernate.HibernateException;
import org.hibernate.Session;


import com.vk.entities.Address;
import com.vk.entities.Employee;
import com.vk.util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
		getEmployeeAndAdressByEmployeeId();
		//getEmployeeAndAdressByAddressId();
	    
	  }

	private static void getEmployeeAndAdressByAddressId() {

	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	Address address = session.get(Address.class, 1);
	    	System.out.println(address);
	    	if(address != null){
	    		System.out.println(address.getEmployee());
	    	}
	    	System.out.println();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}

	private static void getEmployeeAndAdressByEmployeeId() {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	Employee employee2 = session.get(Employee.class , 1);
	    	System.out.println(employee2);
	    	if(employee2 != null){
	    		employee2.getAddressList().forEach(System.out::println);
	    	}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}