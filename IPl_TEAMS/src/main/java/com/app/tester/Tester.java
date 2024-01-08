package com.app.tester;

import org.hibernate.SessionFactory;
import static com.app.utils.HibernateUtill.getFactory;

public class Tester {

	public static void main(String[] args) {
		//get the SessionFactory from Utils
		try (SessionFactory sf = getFactory()){
			System.out.println("Hibernate up and running...!");
			
		}//sf.close() --> Hibernate will auto clean up the DBCP.
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
