package com.niheeth.niheethbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
			@Id
			private int productid;
			private String productname;
			private int price;
			private int quantity;
			private String description;
			public int getProductid() {
				return productid;
			}
			public void setProductid(int productid) {
				this.productid = productid;
			}
			public String getProductname() {
				return productname;
			}
			public void setProductname(String productname) {
				this.productname = productname;
			}
			public int getPrice() {
				return price;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public int getQuantity() {
				return quantity;
			}
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
}
