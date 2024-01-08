package com.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//name (unique) , description ,category(enum) , price , available stock(int),
//expiryDate:LocalDate

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(exclude = "ctg")
@Table (name="products")
public class Product extends BaseEntity{
	@Column (name="product_name", unique=true, length=20)
	private String name;
	@Column (name="description", length=1000)
	private String description;
	@JoinColumn(name="category", nullable=false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Category ctg;
	@Column(name="price", nullable=false)
	private double price;
	@Column(name="stock", nullable=false)
	private int stock;
	@Column(name="expiry_date", nullable=false)
	private LocalDate expiryDate;
}
