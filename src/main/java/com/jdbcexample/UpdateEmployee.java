package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee {

	public static void main(String[] args) {
		int empId=12;
		String empName= "Mango Reddy";
		int empAge= 200;
		
		
		String driverName="com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/newdb";
		String userName="root";
		String password= "Specialone@5586";
		
		
		Connection conn=null;
		Statement smt=null;
		boolean isUpdated;

		
		try {
					Class.forName(driverName);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
								

					try {
						conn = DriverManager.getConnection(url, userName, password);
						smt = conn.createStatement();
						String query= "update employee set emp_name= '"+empName+"',emp_age='"+empAge+"' where emp_id='"+empId;
						
						System.out.println("Query=" +query);
						isUpdated = smt.execute(query);
						System.out.println("isUpdated= "+isUpdated);

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
