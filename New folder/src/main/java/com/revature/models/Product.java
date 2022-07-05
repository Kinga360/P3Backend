package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Categories product;
	private String Description;
	@Column(nullable = false)
	private Double price;
	
	
	
	public Product(String description, Double price) {
		super();
		Description = description;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, Categories product, String description, Double price) {
		super();
		this.id = id;
		this.product = product;
		
		Description = description;
		this.price = price;
		
	}
	public Product(Categories product, String description, Double price) {
		super();
		this.product = product;
		
		Description = description;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Categories getProduct() {
		return product;
	}
	public void setProduct(Categories product) {
		this.product = product;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(Description, id, price, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(Description, other.Description) && id == other.id && Objects.equals(price, other.price)
				&& product == other.product;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product=" + product + ", Description=" + Description + ", price=" + price + "]";
	}
	

}

