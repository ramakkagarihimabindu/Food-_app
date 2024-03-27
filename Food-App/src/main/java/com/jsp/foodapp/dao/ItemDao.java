package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.foodapp.entities.FoodOrder;
import com.jsp.foodapp.entities.Item;

@Component
public class ItemDao {
	@Autowired
	EntityManagerFactory emf;
	public void saveItem(Item i)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(i);
		et.commit();
	}
	public Item viewItemById(int id)
	{
		EntityManager em=emf.createEntityManager();
		Item i=em.find(Item.class,id);
		return i;
	}
	public void updateItem(Item i)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(i);
		et.commit();
	}
	public void deleteItemById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Item i=em.find(Item.class,id);
		et.begin();
		em.remove(i);
		et.commit();
	}
	

}
