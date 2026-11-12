package org.sameer.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException() {
		// TODO Auto-generated constructor stub
		super( "No Student exists with the Id");
	}
}
