package com.jdbc.example.coderefactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee {

	public static void main(String[] args) {
		int empId=3;
		String empName= "Bal Reddy";
		int empAge= 30;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		boolean isUpdated;
					try {
						conn = ConnectionUtil.getConnection();
						//smt = conn.createStatement();
						String query= "update employee set emp_name= ?,emp_age= ? where emp_id=? ";
						
						System.out.println("Query=" +query);
						psmt=conn.prepareStatement(query);
						psmt.setString(1, empName);
						psmt.setInt(2, empAge);
						psmt.setInt(3, empId);
						
						
						isUpdated = psmt.execute();
						System.out.println("isUpdated= "+isUpdated);

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
