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
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="is_bought", nullable = false)
	private boolean isbought;
	
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
	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//	private List<OrderDetail> orderdetails;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(boolean isbought, Long createduser, Long updateduser, Timestamp createdat, Timestamp updatedat,
			Timestamp deletedat,  User user) {
		super();
		this.isbought = isbought;
		this.createduser = createduser;
		this.updateduser = updateduser;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.deletedat = deletedat;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

//	public List<OrderDetail> getOrderdetails() {
//		return orderdetails;
//	}
//
//	public void setOrderdetails(List<OrderDetail> orderdetails) {
//		this.orderdetails = orderdetails;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
