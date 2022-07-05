package com.revature.models;

import java.util.Date;
import java.util.List;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "OrderList")
public class OrderHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int userId;
	private int productId;
	public OrderHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderHistory(int orderId, int userId, int productId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
	}
	public OrderHistory( int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderHistory other = (OrderHistory) obj;
		return orderId == other.orderId && productId == other.productId && userId == other.userId;
	}
	@Override
	public String toString() {
		return "OrderHistory [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + "]";
	}
}
