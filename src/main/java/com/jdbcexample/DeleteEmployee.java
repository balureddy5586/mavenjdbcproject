package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployee {

	public static void main(String[] args) {
		int empId=19;
		
		
		String driverName="com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/newdb";
		String userName="root";
		String password= "Specialone@5586";
		
		
		Connection conn=null;
		Statement smt=null;
		boolean isDeleted;

		
		try {
					Class.forName(driverName);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
								

					try {
						conn = DriverManager.getConnection(url, userName, password);
						smt = conn.createStatement();
						String query= "DELETE from employee where emp_id= "+empId;
						
						System.out.println("Query=" +query);
						isDeleted = smt.execute(query);
						System.out.println("isDeleted= "+isDeleted);

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
