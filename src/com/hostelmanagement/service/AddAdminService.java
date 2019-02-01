package com.hostelmanagement.service;

import java.util.ArrayList;

import com.hostelmanagement.dao.AddAdminDao;
import com.hostelmanagement.model.AdminUserInformation;
import com.hostelmanagement.util.Constants;


public class AddAdminService {

	
	public int addAdminToDatbase(AdminUserInformation adminUserInformation) {
		
		
		if(adminUserInformation.getAuthToken().equalsIgnoreCase(Constants.AUTH_TOKEN)) {
			
			System.out.println("Saving to Database with the following data");
			AddAdminDao addAdminDao=new AddAdminDao();
			return(addAdminDao.addAdminToDatbase(adminUserInformation));
		}
		else {
		return 0;
		}
		
	}

	public boolean validateLogin(AdminUserInformation adminUserInformation) {
		AddAdminDao addAdminDao=new AddAdminDao();
		ArrayList<AdminUserInformation> userInfo=addAdminDao.getUserInfoToValidate(adminUserInformation);
		boolean vlaidUserFlag=false;
		for(AdminUserInformation adminInfo:userInfo) {
			if(adminInfo.getUserEmail().equals(adminUserInformation.getUserEmail())&&adminInfo.getPassword().equals(adminUserInformation.getPassword())) {
				System.out.println("Valid  User");
				vlaidUserFlag=true;
			}
			
			
			
		}
		
		return vlaidUserFlag;
		
	}
}















