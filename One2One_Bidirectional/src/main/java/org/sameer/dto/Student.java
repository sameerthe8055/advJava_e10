package org.sameer.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int sId;
	private String name;
	private int age;
	private String email;
	private String gender;
	
	// orphanRemoval = true(byfault its false) makes the unrefernced inverse entities to be removed from DB when replaced by new inverse entities
	// for example if we replace new certificate with old one, then old orphan cerificate will be removed after its replaced by new certificate.
	// if set false the old one exists in db but not referred by any Owner enitity.
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private BirthCertificate birthCertificate;
	
	
	public BirthCertificate getBirthCertificate() {
		return birthCertificate;
	}
	public void setBirthCertificate(BirthCertificate birthCertificate) {
		this.birthCertificate = birthCertificate;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", age=" + age + ", email=" + email + ", gender=" + gender
				+ ", birthCertificate=" +  
				(birthCertificate != null ?"[cId=" + birthCertificate.getcId() + ", birthTime=" + birthCertificate.getBirthTime() + ", birthDate=" + birthCertificate.getBirthDate() + ", location="
						+ birthCertificate.getLocation() + "]" : "[]")+ "]";
	}
	
	
	

}
