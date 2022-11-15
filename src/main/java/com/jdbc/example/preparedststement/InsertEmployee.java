package com.jdbc.example.preparedststement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// LOAD THE DRIVER
				Class.forName("com.mysql.jdbc.Driver");
				
				
				// GET THE CONNECTION
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "Specialone@5586");
				
				
				//PREPARE THE STATEMENT(STATEMENT OR PREPARED STATEMENT OR CALLABLE STATEMENT)
				//Statement smt  =conn.createStatement();
					PreparedStatement psmt=conn.prepareStatement("INSERT into employee(emp_name,emp_age) values('Bal Kumar Reddy',36)");
				// EXECUTE THE STATEMENT
				boolean isInserted= psmt.execute();
				System.out.println("IsInserted= "+isInserted);
				
	}

}
