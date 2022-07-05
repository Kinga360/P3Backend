package com.revature.repository;

import java.util.ArrayList;


import java.util.List;

import com.revature.models.OrderHistory;
import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.services.CartServices;


public class CheckoutDAO {
	OrderHistory history;
	
	public double checkout(List<Product> cart, int user) {
		
		List<Product> product = cart;
		ArrayList<Product> p = new ArrayList<Product>(product);
		double amount = 0;
		double tax = .08;
		for (Product pr : product) {
			history.setProductId(pr.getId());
			history.setUserId(user);
			double temp =  (pr.getPrice() * tax);
			amount += temp;
		}
		cart.clear();
		return amount;
	}

}
