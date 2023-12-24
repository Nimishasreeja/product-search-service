package com.search.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String keyword;

	private String brand;

	private int position;
	
	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Product(Long id, String keyword, String brand, int position) {
		super();
		this.id = id;
		this.keyword = keyword;
		this.brand = brand;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", keyword=" + keyword + ", brand=" + brand + ", position=" + position + "]";
	}

	

}
