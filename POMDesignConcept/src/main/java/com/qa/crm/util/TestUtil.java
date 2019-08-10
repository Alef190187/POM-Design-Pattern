package com.qa.crm.util;

import com.qa.crm.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT_TIMEOUT = 40;

	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

}
