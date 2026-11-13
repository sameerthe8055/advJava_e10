package org.sameer.dao;

import java.util.List;
import java.util.logging.ErrorManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	
	public void addNewBirthCertifiate(int sId, BirthCertificate newCertificate) {
		Student mStudent = entityManager.find(Student.class, sId);
		BirthCertificate mCertificate = mStudent.getBirthCertificate();
		// begin transaction
		entityTransaction.begin();
		// dereference both Owner and inverse
		mStudent.setBirthCertificate(null);
		mCertificate.setStudent(null);
		
		// Reference Owner and new Inverse Object
		mStudent.setBirthCertificate(newCertificate);
		newCertificate.setStudent(mStudent);
		
		entityTransaction.commit();
		
	}
	public void updateSNameByCertId(int cId,String studNewName) {
		BirthCertificate certificate = entityManager.find(BirthCertificate.class, cId);
		if(certificate != null && certificate.getStudent() != null) {
			
			entityTransaction.begin();
			certificate.getStudent().setName(studNewName);
			entityTransaction.commit();
		}
		else {
			System.out.println("Certificate or Student not found");
		}
		
	}
	
	public void updateBDbySId(int sId, String nBD) {
		Student mStudent = entityManager.find(Student.class, sId);
		
		if(mStudent != null && 
			mStudent.getBirthCertificate() != null) {
			mStudent.getBirthCertificate().setBirthDate(nBD);
			entityTransaction.begin();
			entityTransaction.commit();
		}
		else {
			System.out.println("Student or certificate not found");
		}
		
	}
	
	public List<Student> findAll() {
		String sql = "SELECT s FROM Student s";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
		
	}
	
	public void removeStudent(int sId) {
		Student student =  entityManager.find(Student.class, sId);
		// method 1
//		entityTransaction.begin();
//		entityManager.remove(student);
//		// //entityManager.remove(student.getBirthCertificate());
//		entityTransaction.commit();
		// method 2
		
		
		if(student != null) {
			if(student.getBirthCertificate() != null) {
				BirthCertificate bc = student.getBirthCertificate();
				bc.setStudent(null);
				student.setBirthCertificate(null);
				entityTransaction.begin();
				entityManager.remove(student);
				entityTransaction.commit();
			}else {
				entityTransaction.begin();
				entityManager.remove(student);
				entityTransaction.commit();
			}
		}
		
		
	}

}
