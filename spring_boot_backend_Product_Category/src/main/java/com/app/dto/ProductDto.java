package com.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private String name;
	private String description;
	@JsonProperty(value="product_id", access=Access.READ_ONLY)
	private Long id;
	private double price;
	private int stock;
	private LocalDate expiryDate;
	
}
