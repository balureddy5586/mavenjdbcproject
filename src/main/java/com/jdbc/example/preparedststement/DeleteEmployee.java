package com.jdbc.example.preparedststement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployee {

	public static void main(String[] args) {
		int empId=25;
		
		
		String driverName="com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/newdb";
		String userName="root";
		String password= "Specialone@5586";
		
		
		Connection conn=null;
		PreparedStatement psmt=null;
		boolean isDeleted;

		
		try {
					Class.forName(driverName);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
								

					try {
						conn = DriverManager.getConnection(url, userName, password);
						//smt = conn.createStatement();
						String query= "DELETE from employee where emp_id= ?";
						
						System.out.println("Query=" +query);
						psmt=conn.prepareStatement(query);
						psmt.setInt(1, empId);
						isDeleted = psmt.execute();
						System.out.println("isDeleted= "+isDeleted);

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
