package org.sameer.exception;

public class CertificateNotFoundException extends RuntimeException {
	public CertificateNotFoundException() {
		// TODO Auto-generated constructor stub
		super("No certificate exists with this ID");
	}
}
