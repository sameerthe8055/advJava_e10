package controller;

import dao.EntityDao;
import dto.Passport;
import dto.Person;

public class EntityController {
	public static void main(String[] args) {
		EntityDao dao = new EntityDao();
		
		Passport passport = dao.getPassport(2);
		System.out.println(passport);
		
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
