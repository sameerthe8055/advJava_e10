package org.sameer.controller;

import java.util.ArrayList;
import java.util.List;

import org.sameer.dao.DepartmentDao;
import org.sameer.dto.Department;
import org.sameer.dto.Employee;

public class DepartmentController {
	
	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();
		
		/*
		 # 4. Update emp designation
		 * 
		 */
		dao.updateDesignation(1212, 102, "Frontend Developer");
		
		/*
		 # 3. Remove an employee by deptId & empId
		 *
		dao.removeEmployee(1212, 103);
		 */
		
		/*
		 2. Find department and print
		 *
		System.out.println( dao.findDepartment(1212) );
		 */
		
		
		
		/*
		 * 1. Adding of DEPT & Emp entities
		List<Employee> emps = new ArrayList<Employee>();
		
		emps.add(new Employee(101, "Raju", 22, "raju@gmail.com", "Java Dev"));
		emps.add(new Employee(102, "rani", 21, "rani@gmail.com", "web dev"));
		emps.add(new Employee(103, "radhika", 26, "radhika@gmail.com", "SQL dev"));
		
		Department dept1 = new Department(1212, "Development", "Hyderabad", emps);

		
		dao.addEntity(dept1);		
		 */
		
//		List<Employee> emps = new ArrayList<Employee>();
//		
//		emps.add(new Employee(104, "Rohit", 25, "rohit@gmail.com", "manual tester"));
//		emps.add(new Employee(105, "Shalini", 27, "rani@gmail.com", "automation tester"));
//		
//		
//		Department dept1 = new Department(1213, "Testing", "Banglore", emps);
//		
//		
//		dao.addEntity(dept1);
		
		
		
	}

}
