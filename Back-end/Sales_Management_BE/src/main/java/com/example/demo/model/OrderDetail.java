package com.example.demo.model;

import java.sql.Timestamp;

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
public class OrderDetail {

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
	private boolean isbought;
	
	@Column( name="created_user", nullable = false)
	private Long createduser;
	
	@Column(name="updated_user", nullable = true)
	private Long updateduser;
	
	@Column( name="created_at", nullable = false, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp created_at;
	
	@Column(name="updated_at", nullable = true, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedat;
	
	@Column(name="deleted_at", nullable = true, updatable = false, columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp deletedat;
	
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name="product_id", referencedColumnName = "id")
	private Product product;
	
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name="order_id", referencedColumnName = "id")
	private Order order;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Long quantity, Long size, Long price, boolean isbought, Long createduser, Long updateduser,
			Timestamp created_at, Timestamp updatedat, Timestamp deletedat, Product product, Order order) {
		super();
		this.quantity = quantity;
		this.size = size;
		this.price = price;
		this.isbought = isbought;
		this.createduser = createduser;
		this.updateduser = updateduser;
		this.created_at = created_at;
		this.updatedat = updatedat;
		this.deletedat = deletedat;
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

	public boolean isIsbought() {
		return isbought;
	}

	public void setIsbought(boolean isbought) {
		this.isbought = isbought;
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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
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
