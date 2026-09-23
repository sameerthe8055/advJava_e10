package org.jsp.load_and_register_driver_class;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Type1 {
	public static void main(String[] args) {
		try {
			Driver driver = new Driver(); // Loading
			/* Loading: 
			 Loading and creation of non static member of Driver class will be done here
			 */
			DriverManager.registerDriver(driver); // ResgisterDriver 
			System.out.println("Loading and Register Successfull");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
