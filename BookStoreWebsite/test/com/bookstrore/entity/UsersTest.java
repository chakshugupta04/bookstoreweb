package com.bookstrore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
		Users user1= new Users();
		user1.setEmail("yug@gmail.com");
		user1.setFullName("Yug");
		user1.setPassword("robotic");
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BookStroreWebsie");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("A user object was persisted");
	}

}
