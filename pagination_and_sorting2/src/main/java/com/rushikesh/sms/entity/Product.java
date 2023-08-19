package com.rushikesh.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int quantity;
	private long price;
	
	
	public Product(String name, int quantity, long price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	

}
