/**
 * 
 */
package com.learning.java.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learning.java.Person;
import com.learning.java.api.PhoneNumberStore;
import com.learning.java.imp.PhoneNumberStoreImp;

/**
 * @author User
 *
 */
public class PhoneNumberStoreDefaultAreaCodeTest {

	PhoneNumberStore phoneNumberStore;
	Person person;
	/**
	 * 
	 */
	@BeforeTest
	public void initialStore(){
		phoneNumberStore = new PhoneNumberStoreImp();
		person = new Person("John", "Smith", "32 Altert");
	}
	
	@Test (priority=0)
	public void testFirstNumber(){
		long phoneN = phoneNumberStore.getPhoneNumber();
		Assert.assertEquals(phoneN, (new Long(1111111)).longValue());
		Assert.assertTrue(phoneNumberStore.setInformationForPhoneNumber(phoneN, person));
	}
	
	@Test (priority=1, dependsOnMethods={"testFirstNumber"})
	public void testFirstNumberUsed(){
		long phoneN = phoneNumberStore.getPhoneNumber();
		Assert.assertEquals(phoneN, (new Long(1111112)).longValue());
		Assert.assertTrue(phoneNumberStore.setInformationForPhoneNumber(phoneN, person));
	}
	
	@Test (priority=5)
	public void testFirst5NumberUsed(){
		long phoneN = 1111111;
		for (int i = 0; i < 5; i++){
			Assert.assertTrue(phoneNumberStore.setInformationForPhoneNumber(phoneN+i, person));
		}
		phoneN = phoneNumberStore.getPhoneNumber();
		Assert.assertEquals(phoneN, (new Long(1111116)).longValue());
		Assert.assertTrue(phoneNumberStore.setInformationForPhoneNumber(phoneN, person));
	}

	@Test(priority=6)
	public void testPreferNumber(){
		long phoneN = phoneNumberStore.getPhoneNumber(1111117, true);
		Assert.assertEquals(phoneN, (new Long(1111117)).longValue());
		Assert.assertTrue(phoneNumberStore.setInformationForPhoneNumber(phoneN, person));		
	}
	
	@Test(priority=7)
	public void testPreferNumberAlreadyUsed(){
		long phoneN = phoneNumberStore.getPhoneNumber(1111115, true);
		Assert.assertEquals(phoneN, (new Long(1111118)).longValue());
		Assert.assertTrue(phoneNumberStore.setInformationForPhoneNumber(phoneN, person));		
	}
	
	@Test(priority=7)
	public void testPreferNumberAlreadyUsedNotAcceptChange(){
		long phoneN = phoneNumberStore.getPhoneNumber(1111115, false);
		Assert.assertEquals(phoneN, (new Long(0)).longValue());
	}	
	
	@Test(priority=8)
	public void testCurrentAfterItWasUsedByPrefer(){
		long phoneN = phoneNumberStore.getPhoneNumber();
		Assert.assertEquals(phoneN, (new Long(1111119)).longValue());
		Assert.assertTrue(phoneNumberStore.setInformationForPhoneNumber(phoneN, person));		
	}	
}
