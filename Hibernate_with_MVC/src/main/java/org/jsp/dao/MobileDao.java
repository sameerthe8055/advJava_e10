package org.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.engine.jdbc.ColumnNameCache;
import org.jsp.dto.Mobile;
import org.jsp.exception.MobileAlreadyExistsException;

public class MobileDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("first");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void save(Mobile mobile) {
		Mobile dBMobile = entityManager.find(Mobile.class, mobile.getId());
		
		
		if(dBMobile == null) {
			entityTransaction.begin();
			entityManager.persist(mobile);
			entityTransaction.commit();
		}else {
			throw new MobileAlreadyExistsException();
		}
	}
	
	public void findAllMobiles() {
		String sql = "SELECT m FROM Mobile m";
		Query query = entityManager.createQuery(sql);
		
		List<Mobile> mobiles = query.getResultList();
		for(Mobile mobile:mobiles) {
			System.out.println(mobile);
		}
		
		
	}
	
	public Mobile findByBrandName(String brandName) {
		String sql = "SELECT m FROM Mobile m WHERE brandName=:bName";
		
		Query query = entityManager.createQuery(sql);
		
		query.setParameter("bName", brandName);
		
		Mobile mobile = (Mobile)query.getSingleResult();
		System.out.println(mobile);
		return mobile;
	}
	
	public void update(Mobile mobile) {
		entityTransaction.begin();
		entityManager.merge(mobile);
		entityTransaction.commit();
		
		System.out.println("Updated successfully");
	}
	
	public void updateCost(int id, double value) {
		String sql = "UPDATE Mobile SET cost = :value WHERE id = :id";
		entityTransaction.begin();
		Query query =  entityManager.createQuery(sql);
		query.setParameter("value", value);
		query.setParameter("id", id);
		
		System.out.println(query.executeUpdate());
		entityTransaction.commit();
		
	}
	
	
}
