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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",  length=200, columnDefinition = "nvarchar(200) not null")
	private String name;
	
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
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name, Long createduser, Long updateduser, Timestamp createdat, Timestamp updatedat,
			Timestamp deletedat) {
		super();
		this.name = name;
		this.createduser = createduser;
		this.updateduser = updateduser;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.deletedat = deletedat;
		
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
