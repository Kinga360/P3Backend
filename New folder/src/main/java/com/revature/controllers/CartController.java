package com.revature.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.models.OrderHistory;
import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.repository.CartDAO;
import com.revature.repository.UserDAO;
import com.revature.services.CartServices;
import com.revature.services.ProductServices;
@Controller
@RequestMapping(value="/cartcontroller")
@CrossOrigin
public class CartController {
	static ProductServices ps = new ProductServices();
	static CartServices cs = new CartServices();
	static ArrayList<Product> p = new ArrayList<Product>();
	@GetMapping("/getallcartitems")
	public ResponseEntity<List<Product>> getAllCartItems(){
	//	List<Product> products = cs.getAllUserProducts();
		 ResponseEntity.status(HttpStatus.CREATED).body(p);
		 return ResponseEntity.status(200).body(p);
}
	@PostMapping("/insertproducttocart")
	public static ResponseEntity<Product> insertProduct(@RequestBody int id){
		//System.out.println(product.getId());
	
		if(id == 0) {
			System.out.println("--------------------------------");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			
		}else {	
		Product product =	ps.getProductById(id);
		System.out.print(product);
			p.add(product);
			p = cs.addingToCart(product,p);
			return ResponseEntity.status(HttpStatus.OK).body(product);
		}
	}
		@PostMapping("/removeproducttocart")
		public static ResponseEntity<List<Product>> removeProduct(@RequestBody int id){
			//System.out.println(product.getId());
		
			if(id == 0) {
				System.out.println("--------------------------------");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
				
			}else {	
			
				p.remove(id);
				return ResponseEntity.status(HttpStatus.OK).body(p);
			}
}
	@PostMapping("/checkout")
	public static ResponseEntity<Double> checkout(@RequestBody int userid){
		//System.out.println(product.getId());
	
		if(userid == 0) {
			System.out.println("--------------------------------");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			
		}else {	

			double total = cs.checkout(userid, p);
			return ResponseEntity.status(HttpStatus.OK).body(total);
		}
}	
	@PostMapping("/getOrderHistory")
	public static ResponseEntity<List<OrderHistory>> getOrderHisoty(@RequestBody int userid){
		//System.out.println(product.getId());
	
		if(userid == 0) {
			System.out.println("--------------------------------");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			
		}else {	

			List<OrderHistory> oh = cs.getOrderHistory(userid);
			return ResponseEntity.status(HttpStatus.OK).body(oh);
		}
	}}
	