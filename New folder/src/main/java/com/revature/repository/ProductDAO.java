package com.revature.repository;

import java.util.List;


import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Product;
import com.revature.utilities.HibernateUtil;



import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.utilities.HibernateUtil;

public class ProductDAO {
	@PersistenceContext
	public static void insertProduct(Product product) {
		try (Session ses = HibernateUtil.getSession()){
		ses.save(product);
		HibernateUtil.closeSession(); //This closes the session which will help prevent a memory leak issue
		
		}catch(HibernateException e) {
			System.out.println(e);
			e.printStackTrace();
			
		
		}
	} 
	//We are going to use HQL for this one
		public static List<Product> getAllProducts(){
			Session ses = HibernateUtil.getSession(); //This opens the session
			List<Product> userList = ses.createQuery("FROM Product").list(); //This is HQL which will get all items from the user Table
			HibernateUtil.closeSession(); //This closes the session
			return userList; //This returns the list
		}
		
		public static Product getProductById(int id) {
			Session ses = HibernateUtil.getSession(); //opens the session
			Product product = ses.get(Product.class, id); //This will select all users by ID (This should result in only one user, but id is a PK which is unique)
			HibernateUtil.closeSession(); //closes the session
			return product; //returns the user
		}
		public static Product getByProductName(String name) {
			Session ses = HibernateUtil.getSession(); //This opens the session
			
			Query q = ses.createQuery("FROM Product WHERE gname = ?1");
			q.setParameter(1,name);
			try {
				List<Product> productList = q.getResultList();
				HibernateUtil.closeSession();
				Product p = productList.get(0);
				System.out.println("product exist");
				return p;
			} catch(Exception e) {
				return null;
			}	
		}
}
