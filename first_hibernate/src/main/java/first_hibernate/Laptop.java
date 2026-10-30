package first_hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id
	private int id;
	private String modelName;
	private String processor;
	private int ram;
	private int rom;
	
}
