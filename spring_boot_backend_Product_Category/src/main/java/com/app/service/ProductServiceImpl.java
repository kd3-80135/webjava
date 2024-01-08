package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;
import com.app.dto.AddProductDto;
import com.app.dto.CategoryDto;
import com.app.dto.ProductDto;
import com.app.dto.UpdateProductPriceDto;
import com.app.entities.Category;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao prdDao;
	
	@Autowired
	private CategoryDao ctgDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public AddProductDto addNewProductDetails(Long categoryId, AddProductDto dto) {
		Category category = ctgDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Invalid id."));
		Product product = mapper.map(dto, Product.class);
		product.setCtg(category);
		Product product2 = prdDao.save(product);
		return mapper.map(product2, AddProductDto.class);
	}

	@Override
	public List<ProductDto> getProductsByCategory(@NotBlank String categoryName) {
		return prdDao.findByCtgName(categoryName)
				.stream()
				.map(prd -> mapper.map(prd, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public String deleteProductById(@NotNull Long productId) {
		if (prdDao.existsById(productId)) {
			Product prd = prdDao.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
			prd.setCtg(null);
			prdDao.deleteById(productId);
			return "Product Deletion Successfull!!";
		}
		else {
			throw new ResourceNotFoundException("Product Not Found. Invalid Id.");
		}
	}

	@Override
	public String updateProductsById(UpdateProductPriceDto dto, Long Id) {
		String msg = "Updation Failed!!";
		if (prdDao.existsById(Id)) {
			Product prd = prdDao.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
			prd.setPrice(dto.getPrice());
			Product prd1 = prdDao.save(prd);
			if (prd1 != null) {
				msg = "Updation successfull.";
			}
		}
		return msg;
	}
	
	
	
	
	
	
	 
	
	
	
	
	
	
}



