package org.sameer.controller;

import org.sameer.dao.StudentDao;
import org.sameer.dto.BirthCertificate;
import org.sameer.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		
		dao.findStudent(1);
		dao.findBirthCertificate(1112);
//		
//		BirthCertificate bc1 = new BirthCertificate();
//		bc1.setcId(1112);
//		bc1.setBirthTime("8:30");
//		bc1.setBirthDate("08/06/2003");
//		bc1.setLocation("Nandyal");
//		
//		Student s1 = new Student();
//		s1.setsId(2);
//		s1.setName("Naveed");
//		s1.setEmail("naveed@gmail.com");
//		s1.setAge(2);
//		s1.setGender("male");
//		s1.setBirthCertificate(bc1);
//		
//		bc1.setStudent(s1);
//		
//		dao.addStudent(s1);
//		dao.addCertificate(bc1);
		
		
	}
}
