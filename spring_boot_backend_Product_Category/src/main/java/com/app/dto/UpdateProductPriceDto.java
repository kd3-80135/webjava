package com.app.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateProductPriceDto {
	
	@NotNull
	@Min(10)
	private double price;
	
	
}
