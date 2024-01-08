package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CategoryDao;
import com.app.dto.CategoryDto;
import com.app.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CategoryDao ctgDao;
	
	@Override
	public CategoryDto addCategory(CategoryDto ctg) {
		Category category = ctgDao.save(mapper.map(ctg, Category.class));
		return mapper.map(category, CategoryDto.class);
	}	 
	
}
