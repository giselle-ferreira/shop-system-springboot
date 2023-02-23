package com.onlineshop.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onlineshop.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter	@Setter
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	@Getter	@Setter
	private Instant moment;
	
	private Integer orderStatus;	
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	@Getter	@Setter
	private User client;
	
	@Getter
	@Setter(AccessLevel.NONE) 
	@OneToMany(mappedBy = "id.order") 	
	private final Set<OrderItem> items = new HashSet<>();	
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //so they have the same id
	@Getter	@Setter
	private Payment payment;
	
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}				
	
	public Double getTotal() {
		//sum subtotals
		double sum = 0.0;
		for(OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;		
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}			
	}
}
