package controller;

import java.util.List;

import dao.EntityDao;
import dto.Aadhar;
import dto.Passport;
import dto.Person;

public class EntityController {
	public static void main(String[] args) {
		EntityDao dao = new EntityDao();
		
		List<Person> persons = dao.findAll();
		for(Person p: persons) {
			System.out.println(p);
		}
		
		// Update person email and his licality(passport field)
//		dao.updatePersonEmailAndPPLocatlity(5, "sameer@gmail.com", "India");
		
		// Updating Person details(with detach)
		/*
		 *  Detach functon will make the 
		 *  _____________________________
		 *  Managed Entity to DETACH from PERSISTENCE CONTEXT
		 *  _________________________________________________
		 *  
		 *  In an Upadation Operation, If the managed Entity is not
		 *  been Detached then any changes made to Managed Entity will be
		 *  identified by Automatically by the Hibernate and Changes get 
		 *  applied(Even without calling merge())
		 *  Mandatory:- Transaction should begin and commit
		 */
//		dao.updatePersonName(1, "Raju");
		
		// lets associate another Associated Entity(Aadhar) to Owned(Person) Entity;		
//		Aadhar aadhar = new Aadhar();
//		aadhar.setAadharNumber(123456789012L);
//		aadhar.setAddress("Gandhi Nagar, Nandyal");
//		aadhar.setPincode(518501);
//		
//		Passport pp5 = new Passport();
//		pp5.setPassportId(1005);
//		pp5.setPassportNumber("APNDL52345");
//		pp5.setIssueDate("05-05-2026");
//		pp5.setExpiryDate("04-05-2030");
//		pp5.setLocality("Indian");
//		
//		Person p5 = new Person();
//		p5.setPid(5);
//		p5.setName("Sameer");
//		p5.setEmailId("sameer@gmail.com");
//		p5.setAge(22);
//		p5.setPassport(pp5);
//		p5.setAadhar(aadhar);
		
//		dao.addPerson(p5);
		
//		System.out.println(dao.findPerson(5));
		
		// delete/remove
//		dao.removePerson(2);
		
//		Passport passport = dao.getPassport(2);
//		System.out.println(passport);
		
		
		// add just person without passport/associated entity
//		Person p4 = new Person();
//		p4.setPid(3);
//		p4.setName("Mantri");
//		p4.setEmailId("mantri@email.com");
//		p4.setAge(40);
//		// adding person without persort
//		dao.addPerson(p4);
		
//		Person p3 = dao.findPerson(2);
//		
//		p3.setName("RRani");
//		Passport pp3 = p3.getPassport();	
//		pp3.setExpiryDate("01/01/2030");
//		
//		dao.updatePerson(p3);
		
//		dao.removePerson(2);
		
//		Passport pp2 = new Passport();
//		pp2.setPassportId(1002);
//		pp2.setPassportNumber("QWERTY124");
//		pp2.setIssueDate("01/01/2001");
//		pp2.setExpiryDate("01/01/2021");
//		pp2.setLocality("Russian");
//		
//		
//		Person p2 = new Person();
//		p2.setPid(2);
//		p2.setName("Rani");
//		p2.setEmailId("rani@email.com");
//		p2.setAge(20);
//		p2.setPassport(pp2);
//	
//		dao.addPerson(p2);
//		
//		dao.findPerson(1);
		
//		Passport pp1 = new Passport();
//		pp1.setPassportId(1001);
//		pp1.setPassportNumber("ANCD1231");
//		pp1.setIssueDate("01-01-2022");
//		pp1.setExpiryDate("01-01-2041");
//		pp1.setLocality("Indian");
//		
//		Person p1 = new Person();
//		p1.setPid(1);
//		p1.setName("Raju");
//		p1.setAge(22);
//		p1.setEmailId("raju@gmail.com");
//		p1.setPassport(pp1);	
//		
//		
//		dao.addPassport(pp1);
//		dao.addPerson(p1);
		
		
	}

}
