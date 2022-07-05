package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.OrderHistory;
import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.services.CartServices;
import com.revature.utilities.HibernateUtil;

public class CartDAO {
	private static ArrayList<Product> products = new ArrayList<Product>();
	
	
	public ArrayList<Product> insertUserItem(Product product) {
		products.add(product);
		return products;
	}
	public static ArrayList<Product> getAllUserProducts(){ 
		return products; 
	}
	public CartDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Product>   removeUserItems( int index){
			products.remove(index);
			return products;
			
	}
	public static void clearAllItems( ) {
		products.clear();
	}
public static double checkout(int userId, List<Product> p2) {
		double amount = 0;
		double tax = .08;
		try (Session ses = HibernateUtil.getSession()){
			for (Product p : p2) {
				double temp =  (p.getPrice() * tax);
				amount += temp;
				OrderHistory oh = new OrderHistory(userId,p.getId());
				ses.save(oh);
			}
			clearAllItems();
			HibernateUtil.closeSession(); //This closes the session which will help prevent a memory leak issue
			return amount;
			}catch(HibernateException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		return 0;
	}
public static List<OrderHistory> getOrderbyUserID(int userId) {
	Session ses = HibernateUtil.getSession(); //This opens the session

	Query q = ses.createQuery("FROM OrderHistory WHERE userid = ?1");
	q.setParameter(1,userId);
	try {
		List<OrderHistory> orderList = q.getResultList();
		HibernateUtil.closeSession();
		//OrderHistory oh = orderList.get(0);
		//System.out.println(" exist");
		return orderList;
	} catch(Exception e) {
		return null;
	}
}
}
