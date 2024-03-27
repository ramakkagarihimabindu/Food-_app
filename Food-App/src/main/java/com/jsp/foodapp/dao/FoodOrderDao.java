package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.foodapp.entities.FoodOrder;
import com.jsp.foodapp.entities.User;
@Component
public class FoodOrderDao {
	@Autowired
	EntityManagerFactory emf;
	public void saveFoodOrder(FoodOrder f)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(f);
		et.commit();
	}
	public List<FoodOrder> viewAllFoodOrders()
	{
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select f from FoodOrder f");
		return query.getResultList();
	}
	public FoodOrder viewFoodOrderById(int id)
	{
		EntityManager em=emf.createEntityManager();
		FoodOrder f=em.find(FoodOrder.class,id);
		return f;
	}
	public void updateFoodOrder(FoodOrder f)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(f);
		et.commit();
	}
	public void deleteFoodOrder(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		FoodOrder f=em.find(FoodOrder.class,id);
		et.begin();
		em.remove(f);
		et.commit();
	}
	

}
