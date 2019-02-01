package com.hostelmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hostelmanagement.model.AdminUserInformation;

public class DataBaseConnection {

	public static Connection getConnectionToDB() {
		System.out.println("Enterd to Get Database connection ");
		Connection connection = null;
		try {
			Class.forName(Constants.JDBC_DRIVER);
			connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.PASSWORD);
		} catch (Exception e) {
			System.out.println("Exception Occured");
			e.printStackTrace();
		}

		return connection;
	}
	
	public static int executeStatementWithConnectionAndQuery(Connection connection,String Query) {
		
		int result=0;
		try {
			Statement statement=connection.createStatement();
			 result=statement.executeUpdate(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	public static ResultSet executeThePrepStatement(Connection connection,String Query,AdminUserInformation adminUserInformation ) {
		ResultSet result =null;
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(Query);
			preparedStatement.setString(1, adminUserInformation.getUserEmail());
			 result=preparedStatement.executeQuery();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}
	
}
