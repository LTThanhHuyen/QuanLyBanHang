package com.example.demo.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class Order_Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="quantity", nullable = false)
	private Long quantity;
	
	@Column(name="size", nullable = false)
	private Long size;
	
	@Column(name="price", nullable = false)
	private Long price;
	
	@Column(name="is_bought", nullable = false)
	private boolean is_bought;
	
	@Column( name="created_user", nullable = false)
	private Long created_user;
	
	@Column(name="updated_user", nullable = true)
	private Long updated_user;
	
	@Column( name="created_at", nullable = false, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp created_at;
	
	@Column(name="updated_at", nullable = true, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updated_at;
	
	@Column(name="deleted_at", nullable = true, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp deleted_at;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	public Order_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order_Detail(Long quantity, Long size, Long price, boolean is_bought, Long created_user, Long updated_user,
			Timestamp created_at, Timestamp updated_at, Timestamp deleted_at, Product product, Order order) {
		super();
		this.quantity = quantity;
		this.size = size;
		this.price = price;
		this.is_bought = is_bought;
		this.created_user = created_user;
		this.updated_user = updated_user;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.product = product;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public boolean isIs_bought() {
		return is_bought;
	}

	public void setIs_bought(boolean is_bought) {
		this.is_bought = is_bought;
	}

	public Long getCreated_user() {
		return created_user;
	}

	public void setCreated_user(Long created_user) {
		this.created_user = created_user;
	}

	public Long getUpdated_user() {
		return updated_user;
	}

	public void setUpdated_user(Long updated_user) {
		this.updated_user = updated_user;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Timestamp getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	


}
