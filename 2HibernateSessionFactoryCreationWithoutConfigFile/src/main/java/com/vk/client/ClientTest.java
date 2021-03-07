package com.vk.client;

import org.hibernate.Session;

import com.vk.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//check mysql database version
			String SQL = "SELECT version()";
			String result = (String)session.createNativeQuery(SQL).getSingleResult();
			System.out.println("MySql Version is::");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
