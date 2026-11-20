package org.jsp.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.dto.Department;
import org.jsp.dto.Employee;
import org.jsp.exception.DepartmentAlreadyException;
import org.jsp.exception.DepartmentNotExists;
import org.jsp.exception.EmployeeAlreadyExistsException;
import org.jsp.exception.EmployeeNotExistsException;

public class EmpDeptDao {
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("ManyToOneWOExtraTable");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public void saveEmployee(Employee emp) {
		Employee dbEmp = entityManager.find(Employee.class, emp.getId());
		if(dbEmp == null){
			entityTransaction.begin();
			entityManager.persist(emp);
			entityTransaction.commit();
		}
		else 
			throw new EmployeeAlreadyExistsException();
	}
	
	
	public void saveDepartment(Department dept) {
		Department dbDepartment = entityManager.find(Department.class, dept.getId());
		if(dbDepartment == null) {
			entityTransaction.begin();
			entityManager.persist(dept);
			entityTransaction.commit();
			
		}else 
			throw new DepartmentAlreadyException();
	}
	
	public void addEmployee(Employee emp, int dId) {
		Employee dbEmp = entityManager.find(Employee.class, emp.getId());
		if(dbEmp == null) {
			Department mngdDept = entityManager.find(Department.class, dId);
			if(mngdDept != null) {
				mngdDept.getEmployees().add(emp);
				emp.setDepartment(mngdDept);
				entityTransaction.begin();
				entityManager.merge(emp);
				entityTransaction.commit();
			}else 
				throw new DepartmentNotExists();
		}else
			throw new EmployeeAlreadyExistsException();
	}
	
	public void removeEmployee(int empId) {
		Employee dbEmp =   entityManager.find(Employee.class,empId);
		if(dbEmp != null) {
			Department mngdDepartment = dbEmp.getDepartment();
			Employee mngdEmployee = null;
			for(Employee emp: mngdDepartment.getEmployees()) {
				if(emp.getId() == empId) {
					mngdEmployee = emp;
					break;
				}
			}
			// remove employee from department
			mngdDepartment.getEmployees().remove(mngdEmployee);
			// remove department from emp
			mngdEmployee.setDepartment(null);
			entityTransaction.begin();
			entityManager.remove(mngdEmployee);
			entityManager.merge(mngdDepartment);
			entityTransaction.commit();
		}else
			throw new EmployeeNotExistsException();
	}
}
