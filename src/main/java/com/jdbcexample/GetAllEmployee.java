package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllEmployee {

	public static void main(String[] args) {
		
		
		
		String driverName="com.mysql.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/newdb";
		String userName="root";
		String password= "Specialone@5586";
		
		
		Connection conn=null;
		Statement smt=null;
		ResultSet rs =null;

		
		try {
					Class.forName(driverName);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
								

					try {
						conn = DriverManager.getConnection(url, userName, password);
						smt = conn.createStatement();
						String query= "SELECT * FROM EMPLOYEE";
						
						System.out.println("Query=" +query);
						rs = smt.executeQuery(query);
						while(rs.next())  {
							
							int id =rs.getInt(1);
							String name = rs.getString(2);
							int age = rs.getInt(3);
							System.out.println("id= "+id +" name= " +name +"age=  "+age);
							
						}

					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
					try {
						rs.close();
						smt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
					
				
	}

}
