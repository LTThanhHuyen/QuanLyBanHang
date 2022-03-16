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
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Collection<Order_Detail> order_details;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(boolean is_bought, Long created_user, Long updated_user, Timestamp created_at, Timestamp updated_at,
			Timestamp deleted_at, Collection<Order_Detail> order_details, User user) {
		super();
		this.is_bought = is_bought;
		this.created_user = created_user;
		this.updated_user = updated_user;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.order_details = order_details;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<Order_Detail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(Collection<Order_Detail> order_details) {
		this.order_details = order_details;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
