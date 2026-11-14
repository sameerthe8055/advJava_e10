package org.sameer.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private int deptId;
	private String deptName;
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<Employee> emps;
	
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
	
	public Department(int deptId, String deptName, String location, List<Employee> emps) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
		this.emps = emps;
	}
	
	
	
	public Department() {
		super();
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		String res =  "Department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location + "Employees: [";
		if(emps != null) {
			for(Employee emp : emps) {
				res = res + "\n\t" + emp.toString() + ",";
			}
		}
		return res + "]\n]";
	}
	
	

}
