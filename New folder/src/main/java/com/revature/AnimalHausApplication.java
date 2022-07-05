package com.revature;
import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.revature.controllers.ProductController;
import com.revature.models.Categories;
import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.repository.UserDAO;
import com.revature.services.ProductServices;
import com.revature.utilities.HibernateUtil;



@SpringBootApplication
public class AnimalHausApplication{

	public static void main(String[] args) {
		
//		try(Session ses = HibernateUtil.getSession()){
//			System.out.println("Connection Successful");
////			//Product game = new Product(Categories.Games, "NBA 2K", "2K19", 59.99);
////			//ProductServices ps = new ProductServices();
////			//Product product =ProductServices.getProductById(1);
////			//System.out.println(product);
////			//UserDAO ud = new UserDAO();
////			
////			//ud.insertUser(u1);
//////			List <Product> p = ProductServices.getAllProducts();
//////			System.out.println(p);
//			
////			
//		}
//	catch (HibernateException e) {
//			System.out.println("Connection Failed");
//			e.printStackTrace();
////		}
		//Users u1 = new Users("Momo", "Traore", "MomoT1", "password","momotraore@yahoo.com", "New York");
			SpringApplication.run(AnimalHausApplication.class, args);
			
			System.out.println("Hello");
		
		
//		
//	UserDAO ud = new UserDAO();
//
	

			
	}
	}


	