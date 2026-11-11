package dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int Pid;
	private String name;
	private int age;
	private String emailId;
	
//	@OneToOne
	@OneToOne(cascade = CascadeType.ALL) // If we apply cascade the operation applied on OWNED ENTITY(eg: PERSON) will also be PROPAGATED to ASSOCIATED/RELATED ENTITY(eg: passport)
	private Passport passport;
	public int getPid() {
		return Pid;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	private Aadhar aadhar;
	
	public void setPid(int pid) {
		Pid = pid;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	@Override
	public String toString() {
		return "Person [Pid=" + Pid + ", name=" + name + ", age=" + age + ", emailId=" + emailId + ", passport="
				+ passport + ", aadhar=" + aadhar + "]";
	}
	
	public Aadhar getAadhar() {
		return aadhar;
	}
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	
	
	
	
	
	
	
	
	

}
