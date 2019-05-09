/**
 * 
 */
package com.learning.java.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learning.java.api.PhoneNumberStoreNG;
import com.learning.java.imp.PhoneNumberStoreNGImp;

/**
 * @author User
 *
 */
public class PhoneNumberStoreNGTest {
	PhoneNumberStoreNG psNG;

	/**
	 * 
	 */
	@BeforeTest
	public void setup(){
		psNG = new PhoneNumberStoreNGImp();
	}
	
	@Test(priority=0)
	public void testFirstPhoneNumber(){
		Assert.assertEquals(psNG.getPhoneNumber(), new Long(1111));
	}
	
	@Test(priority=1)
	public void testSecondPhoneNumber(){
		Assert.assertEquals(psNG.getPhoneNumber(), new Long(1112));
	}
	
	@Test(priority=2)
	public void testPreferPhoneNumberNotInUseNotAcceptChange(){
		Assert.assertEquals(psNG.getPhoneNumber(new Long(1113), false), new Long(1113));
	}
	
	@Test(priority=3)
	public void testPreferNumberNotInUserAcceptChange(){
		Assert.assertEquals(psNG.getPhoneNumber(new Long(1115), true), new Long(1115));
	}
	
	

}
