package com.app.dto;

import javax.persistence.Column;

import com.app.entities.BaseEntity;
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
public class CategoryDto{
	
	@JsonProperty(value="category_id", access=Access.READ_ONLY)
	private Long id;
	private String name;
	private String description;
}
