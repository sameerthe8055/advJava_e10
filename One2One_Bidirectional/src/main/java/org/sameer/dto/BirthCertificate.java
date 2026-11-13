package org.sameer.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BirthCertificate {

	@Id
	private int cId;
	private String birthTime;
	private String birthDate;
	private String location;
	
	@OneToOne(mappedBy = "birthCertificate", cascade = CascadeType.ALL)
	private Student student;
	
	
	public int getcId() {
		return cId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getBirthTime() {
		return birthTime;
	}
	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "BirthCertificate [cId=" + cId + ", birthTime=" + birthTime + ", birthDate=" + birthDate + ", location="
				+ location + ", student=" + 
				(student != null ?"[sId=" + student.getsId() + ", name=" + student.getName() + ", age=" + student.getAge() + ", email=" + student.getEmail() + ", gender=" + student.getGender()+ "]" : "[]")+ "]";
	}

	
}
