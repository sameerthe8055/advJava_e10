package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Passport;
import dto.Person;
import exception.PassportNotAssociatedException;
import exception.PersonNotFoundException;

public class EntityDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_rel");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	
	// no need for ASSOCIATED entity to save manually if they have cascaded and attribute is ALL/persist
//	public void addPassport(Passport passport) {
//		transaction.begin();
//		manager.persist(passport);
//		transaction.commit();
//
//	}
	public void addPerson(Person person) {
		transaction.begin();
		manager.persist(person);
		transaction.commit();

	}
	
	public Person findPerson(int pId) {
		Person person = manager.find(Person.class, pId);
		if(person != null) {
//			System.out.println(person);
			return person;
		}
		else {
			throw new PersonNotFoundException();
		}
	}
	
	public void removePerson(int  pId) {
		Person person = findPerson(pId);
		if(person != null) {
			transaction.begin();
			manager.remove(person);
			transaction.commit();
		}
		else {
			throw new PersonNotFoundException();
		}
	}
	
	public void updatePerson(Person person) {
		transaction.begin();
		manager.merge(person);
		transaction.commit();
	}
	
	public Passport getPassport(int pId) {
		Person person =  findPerson(pId);	
		if(person != null) {
			if(person.getPassport() != null) {
				return person.getPassport();
			}else 
				throw new PassportNotAssociatedException();
		}else
			throw new PersonNotFoundException();
	}
	

}
