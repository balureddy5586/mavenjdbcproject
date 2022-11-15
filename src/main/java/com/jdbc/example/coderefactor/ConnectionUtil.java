package com.jdbc.example.coderefactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
		public static Connection getConnection() {
		
			String driverName="com.mysql.jdbc.Driver";
			String url= "jdbc:mysql://localhost:3306/newdb";
			String userName="root";
			String password= "Specialone@5586";
			Connection conn=null;

			try {
				Class.forName(driverName);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				conn = DriverManager.getConnection(url, userName, password);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
