package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {
	private static SessionFactory factory;
	
	//static init block to create singleton SF
	//Configuration -> configure -> buildSessionFactory.
	static {
		//build SF
		factory = new Configuration() //empty config created
					.configure()	  //reads hibernate config xml file and populates it.
					.buildSessionFactory(); //builds instance of SF from the populated configuration.
		System.out.println("SF created ....");
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
}
