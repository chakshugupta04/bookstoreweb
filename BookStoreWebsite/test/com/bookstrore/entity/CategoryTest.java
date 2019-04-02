package com.bookstrore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryTest {

	public static void main(String[] args) {
		Category newcat= new Category("Advance Java");
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BookStroreWebsie");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newcat);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("A Category object was persisted");
	}

}
