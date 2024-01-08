package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="category")
public class Category extends BaseEntity{
	@Column(length=20, unique=true, nullable=false)
	private String name;
	@Column(name="descript", length=2000)
	private String description;
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
}
