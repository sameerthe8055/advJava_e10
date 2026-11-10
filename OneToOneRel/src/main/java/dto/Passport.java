package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {
	@Id
	private int passportId;
	private String passportNumber;
	private String issueDate;
	private String expiryDate;
	private String locality;

	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", passportNumber=" + passportNumber + ", issueDate=" + issueDate
				+ ", expiryDate=" + expiryDate + ", locality=" + locality + "]";
	}
	
	public void printPassport() {
		System.out.println(
				"===Passport Details==="
				+ "Pid: " + passportId
				+ "pnumber: " + passportNumber
				+ "p issued on: " + issueDate
				+ "p exp: " + expiryDate
				);
	}

}
