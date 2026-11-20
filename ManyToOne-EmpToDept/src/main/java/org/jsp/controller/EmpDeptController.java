package org.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsp.dao.EmpDeptDao;
import org.jsp.dto.Department;
import org.jsp.dto.Employee;

public class EmpDeptController {
	public static void main(String[] args) {
		EmpDeptDao dao = new EmpDeptDao();
		
		dao.removeEmployee(8);
		
//		Employee emp1 = new Employee();
//		emp1.setId(8);
//		emp1.setName("Bhidu");
//		
//		dao.addEmployee(emp1, 102);
		
		
//		Employee emp2 = new Employee();
//		Employee emp3 = new Employee();
//		
//		emp2.setId(5);
//		emp2.setName("IronMan");
//		emp3.setId(6);
//		emp3.setName("Superman");
//		
//		Department dept = new Department();
//		dept.setId(102);
//		dept.setName("Testing");
//		
//		emp1.setDepartment(dept);
//		emp2.setDepartment(dept);
//		emp3.setDepartment(dept);
//		
//		List<Employee> emps = new ArrayList<>();
//		emps.add(emp1); 
//		emps.add(emp2);
//		emps.add(emp3);
//		
//		dept.setEmployees(emps);
//		dao.saveDepartment(dept);
		
//		dao.saveEmployee(emp1);
		

	}
}
