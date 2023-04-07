package com.testscripts;

import org.testng.annotations.Test;

public class ParametersUsingRun {
	@Test
	public void m1() {
		System.out.println(System.getProperty("browser"));
	}
}
