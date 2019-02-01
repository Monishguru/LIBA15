package com.hostelmanagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hostelmanagement.model.AdminUserInformation;
import com.hostelmanagement.util.DataBaseConnection;

public class AddAdminDao {
	
	public int addAdminToDatbase(AdminUserInformation adminUserInformation) {
		
		Connection connection = DataBaseConnection.getConnectionToDB();
		
		String query="Insert into Admin_user (Email,UserId,Password) values ('"+adminUserInformation.getUserEmail()+"','"+adminUserInformation.getUserEmail()+"','"+adminUserInformation.getPassword()+"');";
		
		System.out.println("Query to be executed is "+query);
		//	Frame the Query
		//execute the query
		
		return(DataBaseConnection.executeStatementWithConnectionAndQuery(connection, query));
		
	}

	public ArrayList<AdminUserInformation> getUserInfoToValidate(AdminUserInformation adminUserInformation) {
		Connection connection = DataBaseConnection.getConnectionToDB();
		String query="select Email,Password from Admin_User where Email=?";
		ResultSet result=DataBaseConnection.executeThePrepStatement(connection,query,adminUserInformation);
		
		ArrayList<AdminUserInformation> userInfo=new ArrayList<AdminUserInformation>();
		
		try {
			while(result.next()) {
				AdminUserInformation adminUserInfo =new AdminUserInformation();
				adminUserInfo.setUserEmail(result.getString("Email"));
				adminUserInfo.setPassword(result.getString("Password"));
				
				userInfo.add(adminUserInfo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userInfo;
	}
	
	

}
