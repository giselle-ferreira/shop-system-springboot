package com.onlineshop.entities;

import java.io.Serializable;

import com.onlineshop.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Setter(AccessLevel.NONE) 
	@Getter(AccessLevel.NONE)
	@EmbeddedId
	private OrderItemPK id;
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}		
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setOrder(Product product) {
		id.setProduct(product);
	}
}
