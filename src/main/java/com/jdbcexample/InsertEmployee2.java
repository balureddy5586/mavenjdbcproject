package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee2 {

	public static void main(String[] args) {
		
		String empName= "Mango";
		int empAge= 25;
		
		
		String driverName="com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/newdb";
		String userName="root";
		String password= "Specialone@5586";
		
		
		Connection conn=null;
		Statement smt=null;
		boolean isInserted;

		
		try {
					Class.forName(driverName);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
								

					try {
						conn = DriverManager.getConnection(url, userName, password);
						smt = conn.createStatement();
						String query= "INSERT into employee(emp_name,emp_age) values('"+empName+"',"+empAge+")";
						
						System.out.println("Query=" +query);
						isInserted = smt.execute(query);

					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
					try {
						smt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
					
				
	}

}
