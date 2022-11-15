package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// LOAD THE DRIVER
		Class.forName("com.mysql.jdbc.Driver");
		
		
		// GET THE CONNECTION
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "Specialone@5586");
		
		
		//PREPARE THE STATEMENT(STATEMENT OR PREPARED STATEMENT OR CALLABLE STATEMENT)
		Statement smt  =conn.createStatement();
		
			
		// EXECUTE THE STATEMENT
		
		ResultSet rs = smt.executeQuery("SELECT * FROM EMPLOYEE");
		
		while(rs.next())  {
			
			int id =rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			System.out.println("id= "+id +" name= " +name +"age=  "+age);
			
		}

		
		
		
	}

}
