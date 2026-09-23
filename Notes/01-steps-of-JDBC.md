# Steps(5) of JDBC
## 1.1 Loading and Register Driver Class( in Type1)
- first we created the project then added `mysql-connector-j-9.7.0.jar` in the created lib folder in main project/root folder.
- then added the jar file in the build path `configure build path -> add jars -> then selected path of mysql-connector-j -> apply then close`.
- afterwards created a java file then 
	```java
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
	```