package com.springboot.jpa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "productdetails")
public class Product {

	@Id
	@GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", initialValue = 1, allocationSize = 1)
	private int id;

	private String brand;
	private String modelname;
	private String os;
	private String technology;
	private BigDecimal price;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public void setModelname(Object modelname2) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", modelname=" + modelname + ", os=" + os + ", technology="
				+ technology + ", price=" + price + "]";
	}

}
