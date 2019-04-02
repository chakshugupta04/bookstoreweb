package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.hibernate.jdbc.Expectation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;



public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	@BeforeClass
	public static void setUpClass() 
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("BookStroreWebsie");
		 entityManager=entityManagerFactory.createEntityManager();
		 userDAO=new UserDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users user1= new Users();
		user1.setEmail("Akhi@gmail.com");
		user1.setFullName("Akhil");
		user1.setPassword("akhil@jk");
	 
		user1=userDAO.create(user1);
		
		assertTrue(user1.getUserID()>0);
	}
	@Test(expected = PersistenceException.class)
	public void testCreateUserFieldNotSet() {
	Users user1= new Users();
	
	user1=userDAO.create(user1);
	
	}
	@Test 
	public void testUpdateUsers() 
	{
		Users user1=new Users();
		
		user1.setUserID(1);
		user1.setEmail("name@codejava.net");
		user1.setFullName("Rahul");
		user1.setPassword("hellosecret");
		user1=userDAO.update(user1);
		String expected="hellosecret";
		String actual=user1.getPassword();
		assertEquals(expected, actual);
	}	
	@Test
	public void testGetUsersFound() 
	{
		Integer userId=1;
		Users user=userDAO.get(userId);
		if(user!=null) {
		System.out.println(user.getEmail());}
		assertNotNull(user);
	}
	@Test
	public void testGetUsersNotFound() 
	{
		Integer userId=99;
		Users user=userDAO.get(userId);
		assertNull(user);
		}
	@Test
	public void testDeleteUser() 
	{
		Integer userId=6;
		userDAO.delete(userId);
		Users user=userDAO.get(userId);
		assertNull(user);
	}
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUser() 
	{
		Integer userId=5;
		userDAO.delete(userId);
	}
	@Test
	public void testListAll() 
	{
		List<Users> listUsers=userDAO.listAll();
		for(Users users:listUsers)
		{
			System.out.println(users.getEmail());
		}
		assertTrue(listUsers.size()>0);
	}
	@Test
	public void testCount() 
	{
		long totalUsers=userDAO.count();
		assertEquals(4, totalUsers);
	}
	@AfterClass
	public static void tearDownClass() 
	{
		entityManager.close();
		entityManagerFactory.close();
	}
	

}
