package org.ems.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TC_Login extends TestBase{
	
	@BeforeMethod
	public void Login() {
		System.out.println("Steps for login");
	}
	@AfterMethod
	public void Logout() {
		System.out.println("Steps for log out");
	}

}
