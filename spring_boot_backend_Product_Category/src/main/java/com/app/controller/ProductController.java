package com.app.controller;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddProductDto;
import com.app.dto.ProductDto;
import com.app.dto.UpdateProductPriceDto;
import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductService prdService;
	
	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	@PostMapping("/{categoryId}")
	public AddProductDto addNewProduct(@PathVariable Long categoryId,@RequestBody @Valid AddProductDto dto) {
		System.out.println("in add new product method"  + dto);
		return prdService.addNewProductDetails(categoryId, dto);
	}
	
	@GetMapping("/{categoryName}")
	public List<ProductDto> getProductDetails (@PathVariable @NotBlank String categoryName) {
		System.out.println("in getProductDetails " + categoryName);
		return prdService.getProductsByCategory(categoryName);
	}
	
	@PostMapping ("/delete/{productId}")
	public String deleteProducts (@PathVariable @NotNull Long productId) {
		System.out.println("in deleteProducts " + productId);
		return prdService.deleteProductById(productId);
	}
	
	@PutMapping ("/{productId}")
	public String updateProducts (@RequestBody @NotNull UpdateProductPriceDto dto, @RequestParam Long productId){
		System.out.println("in updateProducts method " + dto + productId);
		return prdService.updateProductsById(dto,productId);
	}
	
	
	
}
