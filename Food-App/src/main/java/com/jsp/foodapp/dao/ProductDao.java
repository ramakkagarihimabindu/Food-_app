package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.foodapp.entities.Admin;
import com.jsp.foodapp.entities.Product;

@Component
public class ProductDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveProduct(Product p)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
	}
	public Product viewProductById(int id)
	{
		EntityManager em=emf.createEntityManager();
		Product p=em.find(Product.class,id);
		return p;
		
	}
	public List<Product> viewAllProducts()
	{
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select p from Product p");
		return query.getResultList();
	}
	public void updateProduct(Product p)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();
	}
	public void deleteProductById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Product p=em.find(Product.class,id);
		et.begin();
		em.remove(p);
		et.commit();
	}
}
