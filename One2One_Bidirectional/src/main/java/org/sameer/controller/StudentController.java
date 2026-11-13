package org.sameer.controller;

import java.util.List;

import org.sameer.dao.StudentDao;
import org.sameer.dto.BirthCertificate;
import org.sameer.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		
		
		// Remove Student
//		dao.removeStudent(2);
//		dao.removeStudent(1);
		
		/*
		 # find all students
		 * 
		List<Student> students = dao.findAll();
		for(Student student :  students) {
			System.out.println(student);
		}
		 */
		
		/*
		 # Update BirtDate using student id
		 * 
		dao.updateBDbySId(1, "20/12/2004");
		 */
		
		/*
		 Update student name using certificate Id
		dao.updateSNameByCertId(1111, "Shaik Sameer Basha");
		 */
		
		/*
		 # with orphanRemoval = true ->add new inverse entity + old inverse orphan entity will be deleted from db 
		 * to acheive this we just new to add parameter orphanRemoval = true in @OneToOne
		 *
		BirthCertificate bc3 = new BirthCertificate();
		bc3.setcId(3232);
		bc3.setBirthTime("4:30");
		bc3.setBirthDate("01/02/2002");
		bc3.setLocation("Channpatna, Karnataka");
		
		dao.addNewBirthCertifiate(2, bc3);
		 */
		
//		dao.findBirthCertificate(1112); // orphan certificate
		//  // //BirthCertificate [cId=1112, birthTime=8:30, birthDate=08/06/2003, location=Nandyal, student=[ ]]
		
		/*
		 # replace the certificate with new one(without orphan removal)
		 * Without orphanRemoval = true
		 * the old certicate is not removed from DB
		 * ________________________________________
		 * to remove it we should go "orphanRemoval=true" 
		BirthCertificate bc2 = new BirthCertificate();
		bc2.setcId(2121);
		bc2.setBirthTime("4:30");
		bc2.setBirthDate("01/02/2002");
		bc2.setLocation("Chandbada, Nandyal");
		
		dao.addNewBirthCertifiate(2, bc2);
		 */
		
		
		  
//		dao.findStudent(1);
//		dao.findBirthCertificate(1112);
//		
		
		/*
		BirthCertificate bc1 = new BirthCertificate();
		bc1.setcId(1111);
		bc1.setBirthTime("07:30");
		bc1.setBirthDate("20/12/2004");
		bc1.setLocation("Nandyal");
		
		Student s1 = new Student();
		s1.setsId(1);
		s1.setName("Sameer");
		s1.setEmail("sameer@gmail.com");
		s1.setAge(22);
		s1.setGender("male");
		s1.setBirthCertificate(bc1);
		
		bc1.setStudent(s1);
		
		dao.addStudent(s1);
		 */
		
		
		
//		dao.addCertificate(bc1);
		
		
	}
}
