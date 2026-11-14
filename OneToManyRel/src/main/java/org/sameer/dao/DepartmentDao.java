package org.sameer.dao;

import java.beans.PersistenceDelegate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.sameer.dto.Department;
import org.sameer.dto.Employee;
import org.sameer.exception.DepartmentNotFoundException;
import org.sameer.exception.EmployeeNotFoundException;

public class DepartmentDao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("one2many");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction tran = manager.getTransaction();

	public void addEntity(Department department) {
		tran.begin();
		manager.persist(department);
		tran.commit();
		
	}
	
	public Department findDepartment(int dId) {
		Department dept = manager.find(Department.class, dId);
		if(dept != null) 
			return dept;
		else 
			throw new DepartmentNotFoundException("No department found with DeptId: " + dId);
	}
	
	public void removeEmployee(int deptId, int empId) {
		Department department = manager.find(Department.class, deptId);
		Employee managedEmp = null;
		if(department != null) {
			for(Employee emp : department.getEmps()) {
				if(emp.getEmpId() == empId) {
					managedEmp = emp;
					break;
				}
			}
		}else {
			throw new DepartmentNotFoundException("No department exists with given deptId: "+ deptId);
		}
		
		if(managedEmp != null) {
			tran.begin();
			department.getEmps().remove(managedEmp);
			tran.commit();
			System.out.println("Following Employee has been removed: "+ "\n\t" + managedEmp);
			
		}else {
			throw new EmployeeNotFoundException("No employee found with empId: "+ empId);
		}
	}
	public void updateDesignation(int deptId, int empId, String newDesignation) {
		Department department = manager.find(Department.class, deptId);
		Employee managedEmp = null;
		if(department != null) {
			for(Employee emp : department.getEmps()) {
				if(emp.getEmpId() == empId) {
					managedEmp = emp;
					break;
				}
			}
		}else {
			throw new DepartmentNotFoundException("No department exists with given deptId: "+ deptId);
		}
		
		if(managedEmp != null) {
			tran.begin();
			managedEmp.setDesignation(newDesignation);
			tran.commit();
			System.out.println("Following Employee has been updated: "+ "\n\t" + managedEmp);
			
		}else {
			throw new EmployeeNotFoundException("No employee found with empId: "+ empId);
		}
	}
}
