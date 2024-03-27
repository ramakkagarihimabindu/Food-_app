package com.jsp.foodapp.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.foodapp.entities.Admin;

@Component
public class AdminDao {
	@Autowired
	EntityManagerFactory emf;
	public void saveAdmin(Admin a)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(a);
		et.commit();
		
	}
	public void updateAdmin(Admin a)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(a);
		et.commit();
		
	}
	public List<Admin> viewAllAdmins()
	{
		EntityManager em=emf.createEntityManager();
		
		Query query=em.createQuery("select a from Admin a");
		return query.getResultList();
	}
	public void deleteAdmin(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Admin a=em.find(Admin.class,id);
		et.begin();
		em.remove(a);
		et.commit();
		
	}
	public Admin login(String email,String password)
	{
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select a from Admin a where a.email=?1 and a.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
			List<Admin> admin=query.getResultList();
			if(admin.size()>0)
			{
				return admin.get(0);
			}
			else return null;
	}

}
