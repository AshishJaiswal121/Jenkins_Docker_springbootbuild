package com.nagarro.training.springboot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//bean class for product details
@Entity
public class AllProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	@Override
	public String toString() {
		return "AllProduct [id=" + id + ", name=" + name + ", image=" + image + ", brand=" + brand + ", price=" + price
				+ ", productcode=" + productcode + ", description=" + description + "]";
	}

	public AllProduct(long id, String name, String image, String brand, long price, String productcode,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.brand = brand;
		this.price = price;
		this.productcode = productcode;
		this.description = description;
	}

	public AllProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	private String name;
	private String image;
	private String brand;
	private long price;
	private String productcode;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
