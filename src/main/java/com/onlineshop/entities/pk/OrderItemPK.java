package com.onlineshop.entities.pk;

import java.io.Serializable;

import com.onlineshop.entities.Order;
import com.onlineshop.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

//Auxiliar class - primary key for OrderItem
@Data
@EqualsAndHashCode
@Embeddable
public class OrderItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;	
	
}
