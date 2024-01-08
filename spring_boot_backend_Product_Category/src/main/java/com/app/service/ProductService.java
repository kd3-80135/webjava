package com.app.service;


import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.dto.AddProductDto;
import com.app.dto.ProductDto;
import com.app.dto.UpdateProductPriceDto;
import com.app.entities.Product;

public interface ProductService {

	AddProductDto addNewProductDetails(Long categoryId, AddProductDto dto);

	List<ProductDto> getProductsByCategory(@NotBlank String categoryName);

	String deleteProductById(@NotNull Long productId);

	String updateProductsById(UpdateProductPriceDto dto, Long productId);
		
}
