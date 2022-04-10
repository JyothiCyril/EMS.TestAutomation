package org.ems.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	@BeforeClass
	public void setUp() {
		// Opening the browser and launching URL
	}
	
	@AfterClass	
	public void tearDown() {
		// close the browser
	}

}
