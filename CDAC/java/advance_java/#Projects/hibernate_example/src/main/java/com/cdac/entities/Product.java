package com.cdac.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, unique = true)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(length = 200)
	private String description;
	
	private LocalDate mfgDate;
	
	private double price;
	
	private int availableQuantity;
	
	public Product() {
	}
	
	public Product(Long id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(String name, Category category, String description, LocalDate mfgDate, double price, int availableQuantity) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.mfgDate = mfgDate;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
	
	public Product(Long id, String name, Category category, String description, LocalDate mfgDate, double price, int availableQuantity) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.mfgDate = mfgDate;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", mfgDate=" + mfgDate + ", price=" + price + ", availableQuantity=" + availableQuantity + "]";
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
}
