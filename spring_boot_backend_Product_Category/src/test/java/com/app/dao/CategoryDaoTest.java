package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class CategoryDaoTest {
	
	@Autowired
	private CategoryDao ctgDao;

	@Test
	void testAddNewCategory() {
		List<Category> list = List.of(new Category("perishable", "It can get bad quickly. Sell it as fast as you can."),
										new Category("electronic", "Good products of decent companies with ample warranty."),
										new Category("brittle", "handle with care, otherwise ok."),
										new Category("plastic", "durable and flexible"));
		List<Category> list2 = ctgDao.saveAll(list);
		assertEquals(4, list2.size());
		
	
	}

}
