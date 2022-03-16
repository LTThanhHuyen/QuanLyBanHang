package com.example.demo.model;

import java.security.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",  length=200, columnDefinition = "nvarchar(200) not null")
	private String name;
	
	@Column(name="quantity", nullable = false)
	private Long quantity;
	
	@Column(name="price", nullable = false)
	private Long price;
	
	@Column(name="image", nullable = false)
	private String image;
	
	@Column(name="status", nullable = false)
	private String status;
	
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
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Collection<Order_Detail> order_details;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Long quantity, Long price, String image, String status, Long created_user,
			Long updated_user, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at, Category category,
			Collection<Order_Detail> order_details) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.status = status;
		this.created_user = created_user;
		this.updated_user = updated_user;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.category = category;
		this.order_details = order_details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Collection<Order_Detail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(Collection<Order_Detail> order_details) {
		this.order_details = order_details;
	}
	
	
	
	
}
