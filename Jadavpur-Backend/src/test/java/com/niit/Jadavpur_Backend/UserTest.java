package com.niit.Jadavpur_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Jadavpur_Backend.DAO.UserDAO;
import com.niit.Jadavpur_Backend.modal.Address;
import com.niit.Jadavpur_Backend.modal.User;

public class UserTest 
{
	private static AnnotationConfigApplicationContext context;
	static User user;
	static UserDAO userDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Jadavpur_Backend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testInsert()
	{
		
		
		user = new User();
	
		user.setContactNumber("9038760522");
		user.setEmail("debtanayadutta@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Debtanaya");
		user.setLastName("Dutta");
		user.setPassword("dd22211");
		user.setRole("USER");
	
		
	    /*
		user.setContactNumber("9076244550");
		user.setEmail("amitpatra@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Amit Kumar");
		user.setLastName("Patra");
		user.setPassword("akp1993");
		user.setRole("ADMIN");
	    */
		
		
		/*
		user.setContactNumber("9033662457");
		user.setEmail("aakashroy@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Aakash");
		user.setLastName("Roy");
		user.setPassword("ar55500");
		user.setRole("SUPPLIER");
	    */
		
		assertEquals("Error inserting user" ,  true , userDAO.insert(user));
		
	}
	
	//@Test
	public void testGetUser()
	{
		user = userDAO.getUser("rohan@gmail.com");
		assertEquals("Error fetching user" , "Rohan" , user.getFirstName());
	}
	
	
	//@Test
		public void testSupplierList()
		{
			user = userDAO.getUser("rohan@gmail.com");
			assertEquals("Error fetching user" , 2 , userDAO.getSupplierList().size());
		}
		
		
	//@Test
		public void testAddUser() 
		{
			
			Address address = new Address();
			address.setAddressLineOne("31/1 abcd road");
			address.setAddressLineTwo("Near South City");
			address.setCity("Jadavpur");
			address.setState("West Bengal");
			address.setCountry("India");
			address.setPostalCode("700026");
			address.setShipping(true);
			
			address.setUserId(33);
				
			assertEquals("Failed to add the billing address!", true, userDAO.insertAddress(address));
			
			
			
			
		}
	
}
