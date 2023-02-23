package com.onlineshop.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "tb_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Getter @Setter private String name;
	@Getter @Setter private String descrition;
	@Getter @Setter private Double price;
	@Getter @Setter private String imgUrl;

	// it's instantiated so the collection won't start as null
	// Set is an interface, can't be instantiated. Hence the use of HashSet
	@ManyToMany
	@Getter @Setter(AccessLevel.NONE)
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private final Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product(Long id, String name, String descrition, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.descrition = descrition;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	@JsonIgnore
	public Set<Order> getOrders(){
		//for each orderItem, get the order associated to it
		Set<Order> set = new HashSet<>();
		
		for(OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;
	}	
}
