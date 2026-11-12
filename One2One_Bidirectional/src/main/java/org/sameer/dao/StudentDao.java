package org.sameer.dao;

import java.util.logging.ErrorManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.sameer.dto.BirthCertificate;
import org.sameer.dto.Student;
import org.sameer.exception.CertificateNotFoundException;
import org.sameer.exception.StudentNotFoundException;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("one2onebi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

	}
	
	public void addCertificate(BirthCertificate certificate) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(certificate);
		entityTransaction.commit();

	}
	
	public void findStudent(int sid) {
		Student student =  entityManager.find(Student.class, sid);
		if(student != null) {
			System.out.println(student);
		}
		else {
			throw new StudentNotFoundException();
		}
	}
	
	public void findBirthCertificate(int cId) {
		BirthCertificate certificate =  entityManager.find(BirthCertificate.class, cId);
		if(certificate != null) {
			System.out.println(certificate);
		}
		else {
			throw new CertificateNotFoundException();
		}
	}

}
