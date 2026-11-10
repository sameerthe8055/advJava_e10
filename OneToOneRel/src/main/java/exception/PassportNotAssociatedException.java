package exception;

public class PassportNotAssociatedException extends RuntimeException {
	
	public PassportNotAssociatedException() {
		// TODO Auto-generated constructor stub
		super("Passpert not exists foe this person");
	}

}
