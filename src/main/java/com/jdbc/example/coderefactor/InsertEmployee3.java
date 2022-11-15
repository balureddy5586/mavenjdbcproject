package com.jdbc.example.coderefactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee3 {

	public static void main(String[] args) {
		
		String empName= "Mango1";
		int empAge= 25;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		boolean isInserted;

		
					try {
						conn = ConnectionUtil.getConnection();
						//smt = conn.createStatement();
						String query= "INSERT into employee(emp_name,emp_age) values('"+empName+"',"+empAge+")";
						
						System.out.println("Query=" +query);
						 psmt=conn.prepareStatement(query);
						isInserted = psmt.execute();
						System.out.println("IsInserted= " +isInserted);
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
					try {
						psmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
					
				
	}

}
