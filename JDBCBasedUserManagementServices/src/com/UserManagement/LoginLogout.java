package com.UserManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginLogout {
	static Scanner sc = new Scanner(System.in);
	static Connection connection;
	static Statement statement;

	

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc_project";
			String user = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			
			while(true) {
				int ip = Utilities.getInt(sc, "1.Login \t2.Signup \t3.Exit\nEnter an option to continue: ");
				if(ip == 1) {
					login();
				}
				else if(ip == 2) {
					signup();
				}
				else if(ip == 3) {
					System.out.println("Exciting...");
					break;
				}
				else System.out.println("Enter valid input: ");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static void login() {
		// login credentials check
		String sql = "SELECT name, uname, password FROM users_management WHERE role = 'admin'";
		
		ResultSet set;
		try {
			set = statement.executeQuery(sql);
			while(true) {
				String username = Utilities.getString(sc, "Enter user name: ");
				String password = Utilities.getString(sc, "Enter your password: ");
			boolean loggedIn = false;
				while(set.next()) {
					if(set.getString("uname").equals(username) &&
							set.getString("password").equals(password)) {
						loggedIn = true;	
						break;
					}
				}
				if(loggedIn) {
					System.out.println("Login Succesful...");
					System.out.println("Welcome "+ username+"!");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	private static void signup() {
		// TODO Auto-generated method stub
		System.out.println("For signup provide your information");
		String name = Utilities.getString(sc, "Enter your name: ");
		String email = Utilities.getString(sc, "Enter email: ");
		String uname = Utilities.getString(sc, "Enter username:");
		String password;
		while(true) {
			password = Utilities.getString( sc, "Enter password:");
			String confirmpassword = Utilities.getString(sc, "Confirm password: ");
			if(password.equals(confirmpassword)) break;
			System.out.println("Passwords do not match...\nEnter again.");
		}
		long phone = Utilities.getLong(sc, "Enter your phone: ");
		String role;
		while(true) {
			 int n = Utilities.getInt(sc, "1. user 2. admin\nSelect a role from above: ");
			 if(n == 1) {
				 role = "user";
				 break;
			 }
			 else if(n == 2) {
				 role = "admin";
				 break;
			 }
		}
		String sql = "INSERT INTO users_management(name, uname, password, email, phone, role) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, uname);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.setLong(5, phone);
			ps.setString(6, role);
			
			int update = ps.executeUpdate();
			if(update != 1) {
				System.out.println("Id not created...\nTry again");
			}
			else {
				System.out.println("Id created Successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;		
		
	}
	public static void adminPOV() {
		System.out.println("*****************************************\nAdmin Page\n*****************************************");
		while(true) {
			System.out.println("1. Add user\n2. Remove User by ID\n3. Remove ");
			int ip = Utilities.getInt(sc, "Enter a valid option: ");
		}
	}
	
	



}
