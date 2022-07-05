package com.revature.repository;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Users;
import com.revature.utilities.HibernateUtil;

@Repository
public class UserDAO {
//	 
	
	@PersistenceContext
	public int insertUser(Users user) {
		try (Session ses = HibernateUtil.getSession()){
		ses.save(user);
		HibernateUtil.closeSession(); //This closes the session which will help prevent a memory leak issue
		return 0;
		}catch(HibernateException e) {
			System.out.println(e);
			e.printStackTrace();
			return 0;
		
		}
	} 
	
	//We are going to use HQL for this one
	public static List<Users> getAllUsers(){
		Session ses = HibernateUtil.getSession(); //This opens the session
		List<Users> userList = ses.createQuery("FROM Users").list(); //This is HQL which will get all items from the user Table
		HibernateUtil.closeSession(); //This closes the session
		return userList; //This returns the list
	}
	public static List<Users> getAllContractors(){
		Session ses = HibernateUtil.getSession(); //This opens the session
		List<Users> userList = ses.createQuery("FROM Users WHERE role = 1").list(); //This is HQL which will get all items from the user Table
		HibernateUtil.closeSession(); //This closes the session
		return userList; //This returns the list
	}
	public static List<Users> getAllCustomers(){
		Session ses = HibernateUtil.getSession(); //This opens the session
		List<Users> userList = ses.createQuery("FROM Users WHERE role = 0").list(); //This is HQL which will get all items from the user Table
		HibernateUtil.closeSession(); //This closes the session
		return userList; //This returns the list
	}
	public Users getUsersById(int id) {
		Session ses = HibernateUtil.getSession(); //opens the session
		Users user = ses.get(Users.class, id); //This will select all users by ID (This should result in only one user, but id is a PK which is unique)
		HibernateUtil.closeSession(); //closes the session
		return user; //returns the user
	}
	public static Users getByUserName(String userName) {
		Session ses = HibernateUtil.getSession(); //This opens the session
	
		Query q = ses.createQuery("FROM Users WHERE username = ?1");
		q.setParameter(1,userName);
		try {
			List<Users> userList = q.getResultList();
			HibernateUtil.closeSession();
			Users u = userList.get(0);
			System.out.println("user exist");
			return u;
		} catch(Exception e) {
			return null;
		}
		
		
	
		
	}
	



}
