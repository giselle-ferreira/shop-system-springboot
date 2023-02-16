package com.onlineshop.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.onlineshop.entities.Order;
import com.onlineshop.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//Auxiliar class - primary key for OrderItem
@Getter
@Setter
@Embeddable
public class OrderItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}	
	
	
	
}
