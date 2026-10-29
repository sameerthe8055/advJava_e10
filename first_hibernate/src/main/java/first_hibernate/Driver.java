package first_hibernate;

import java.beans.PersistenceDelegate;
import java.util.logging.ErrorManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("first");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setId(101);
		mobile.setBrandName("ChappalPhone");
		mobile.setRam(12);
		mobile.setRom(1024);
		mobile.setCost(5499);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityTransaction.commit();
;	}
}
