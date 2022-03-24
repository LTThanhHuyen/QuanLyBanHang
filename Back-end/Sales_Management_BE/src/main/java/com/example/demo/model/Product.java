package com.example.demo.model;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

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
	private Long createduser;
	
	@Column(name="updated_user", nullable = true)
	private Long updateduser;

	@Column( name="created_at", nullable = false, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdat;
	
	@Column(name="updated_at", nullable = true, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedat;
	
	@Column(name="deleted_at", nullable = true, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp deletedat;
	
	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name="category_id", referencedColumnName = "id")
	private Category category;
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	private List<OrderDetail> orderdetails;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Long quantity, Long price, String image, String status, Long createduser,
			Long updateduser, Timestamp createdat, Timestamp updatedat, Timestamp deletedat, Category category) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.status = status;
		this.createduser = createduser;
		this.updateduser = updateduser;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.deletedat = deletedat;
		this.category = category;
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

	public Long getCreateduser() {
		return createduser;
	}

	public void setCreateduser(Long createduser) {
		this.createduser = createduser;
	}

	public Long getUpdateduser() {
		return updateduser;
	}

	public void setUpdateduser(Long updateduser) {
		this.updateduser = updateduser;
	}

	public Timestamp getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Timestamp createdat) {
		this.createdat = createdat;
	}

	public Timestamp getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Timestamp updatedat) {
		this.updatedat = updatedat;
	}

	public Timestamp getDeletedat() {
		return deletedat;
	}

	public void setDeletedat(Timestamp deletedat) {
		this.deletedat = deletedat;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public List<OrderDetail> getOrderdetails() {
//		return orderdetails;
//	}
//
//	public void setOrderdetails(List<OrderDetail> orderdetails) {
//		this.orderdetails = orderdetails;
//	}

	
}
