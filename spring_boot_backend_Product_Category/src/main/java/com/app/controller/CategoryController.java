package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CategoryDto;
import com.app.entities.Category;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService ctgService;
	
	public CategoryController() {
		System.out.println("In ctor of " + getClass().getName());
	}
	
	@PostMapping
	public CategoryDto addCategoryDetails(CategoryDto dto) {
		System.out.println("in add category details method.");
		return ctgService.addCategory(dto);
		
		
	}
	
}
