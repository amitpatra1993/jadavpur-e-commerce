package com.niit.Jadavpur_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.Jadavpur_Backend.DAO.CategoryDAO;
import com.niit.Jadavpur_Backend.modal.Category;

public class CategoryTest 
{
	private static AnnotationConfigApplicationContext context;
	static Category category;
	static CategoryDAO categoryDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Jadavpur_Backend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	@Test
	public void testInsert()
	{
		category = new Category();
		//category.setId(9);
		category.setCategoryName("AC");
		category.setDescription("Sample category for AC");
		category.setActive(true);
		
		assertEquals("Error adding Category" , true, categoryDAO.insert(category));
	}
	//@Test
	public void testDelete()
	{
		category = categoryDAO.getCategory(2);
		
		assertEquals("Error deleting Category" , true, categoryDAO.delete(category));
	}
	
	//@Test
	public void testUpdate()
	{
		category = categoryDAO.getCategory(1);
		category.setCategoryName("Television");
		assertEquals("Error updating Category" , true, categoryDAO.update(category));
	}
	
	@Test
		public void testCategoryList()
		{
			
			assertEquals("Error updating Category" ,4, categoryDAO.categoryList().size());
		}


}
