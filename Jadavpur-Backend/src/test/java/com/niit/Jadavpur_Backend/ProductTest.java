package com.niit.Jadavpur_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.modal.Product;

public class ProductTest 
{

	private static AnnotationConfigApplicationContext context;
	static Product product;
	static ProductDAO productDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Jadavpur_Backend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testInsert()
	{
		product = new Product();
		//product.setId(17);
		product.setName("mi Smart Watch id-116");
		product.setBrand("mi");
		product.setDescription("Fitness Tracker Blood Pressure Heart Rate Monitor for Girls & Boys with HT1 Wireless Bluetooth Headset Hand-Free Calling");
		product.setUnitPrice(1679);
		product.setActive(true);
		product.setCategoryId(8);
		product.setSupplierId(7);
		product.setQuantity(82);
		
		assertEquals("Error" , true , productDAO.insert(product));
	}
	
	  //@Test
		public void testGetProduct()
		{
			product = productDAO.getProduct(1);
			
			assertEquals("Error" , "PRDf311b4016544", product.getCode());
		}
		
	   //@Test
		public void testActiveProduct()
		{
			assertEquals("Error" ,4, productDAO.listActiveProducts().size());
		}
		
		@Test
		public void testActiveCategoryProduct()
		{
			assertEquals("Error" ,5, productDAO.listActiveProductsByCategory(6).size());
		}
		
	
	 
}
