package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
}
