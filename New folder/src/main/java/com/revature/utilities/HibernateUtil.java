package com.revature.utilities;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	private static Session ses;
	
	public static Session getSession() {
		if(ses == null) { //if there isn't a session
			ses = sf.openSession();
		}
		return ses; //This will just return our session object
	}
	public static void closeSession() {
		ses.close();
		ses = null;
	}

}