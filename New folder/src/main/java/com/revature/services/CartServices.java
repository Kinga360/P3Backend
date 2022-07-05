package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.OrderHistory;
import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.repository.CartDAO;
import com.revature.repository.CheckoutDAO;
import com.revature.repository.ProductDAO;

public class CartServices {
	private static CartDAO cd;
	ArrayList<Product> cartList = new ArrayList<Product>();
	private static ProductDAO pd;
	private static UserServices us;
	public CartServices(CartDAO cart) {
		this.cd= cart; 
				
	}
	public List<Product> getAllUserProducts() {
	
		 cartList = cd.getAllUserProducts();
		return cartList;
	}
	public void clearAllItems() {
		cd.clearAllItems();
	}
	public List<Product> removeUserItems( int index) {
		cartList = cd.removeUserItems(index);
		return cartList;
	}
	public List<Product> insertProduct(Product product) {
		
		cartList = cd.insertUserItem(product);
		return cartList;
	}
	
	
	public CartServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Product> addingToCart(Product p,ArrayList<Product> products){
		
		cartList.add(p);
		System.out.println(cartList);
		return cartList;
		
	}
	public double checkout(int userid, ArrayList<Product> p) {
		
		Users user =us.getUserById(userid);
		return CartDAO.checkout(user.getId(),p);
	}
	public List<OrderHistory> getOrderHistory(int userId){
		return CartDAO.getOrderbyUserID(userId);
	}
}
