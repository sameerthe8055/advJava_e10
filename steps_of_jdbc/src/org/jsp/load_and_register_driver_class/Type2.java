package org.jsp.load_and_register_driver_class;

public class Type2 {
	public static void main(String[] args) {
		try {
			// By using Class.forName we can load and register or DB Driver class 
			Class.forName("com.mysql.cj.jdbc.Driver"); // Loading and Registering
			System.out.println("Loading and Registering done Successfully");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
