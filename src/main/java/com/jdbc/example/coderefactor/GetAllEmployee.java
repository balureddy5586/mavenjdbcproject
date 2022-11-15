package com.jdbc.example.coderefactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllEmployee {

	public static void main(String[] args) {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs =null;

		
		try {
						conn = ConnectionUtil.getConnection();
						//smt = conn.createStatement();
						String query= "SELECT * FROM EMPLOYEE";
						psmt=conn.prepareStatement(query);
						System.out.println("Query=" +query);
						rs = psmt.executeQuery();
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
						psmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
					
				
	}

}
