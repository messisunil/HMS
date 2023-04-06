package com.testscripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersClass {

	@Parameters("Browser")
	@Test
	public void m1(String browser) {
		System.out.println("Browser Name : "+browser);
	}
	
}
