package exception;

public class PersonNotFoundException extends RuntimeException {
	public PersonNotFoundException() {
		super("ID doesn't exist");
		// TODO Auto-generated constructor stub
	}
}
