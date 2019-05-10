package com.learning.java.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.java.api.PhoneNumberStoreNG;
import com.learning.java.imp.PhoneNumberStoreNGImp;

public class NewPhoneNumberStoreNGTest {

	@Test
	public void testFirstPhoneNumber() {
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		Assert.assertEquals(psng.getPhoneNumber(), new Long(1111));
	}

	@Test
	public void testGetPhoneNumberWithoutPrefer() {
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.setCurrentIndex(1);

		Assert.assertEquals(psng.getPhoneNumber(), new Long(1113));
		Assert.assertEquals(psng.getCurrentIndex(), 2);
	}

	@Test
	public void testGetPhoneNumberWithoutPreferWithOneMorePhoneInTheList() {
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.addPhoneNumber(2, new Long(1113));
		psng.setCurrentIndex(1);

		Assert.assertEquals(psng.getPhoneNumber(), new Long(1114));
		Assert.assertEquals(psng.getCurrentIndex(), 3);
	}

	@Test
	public void testGetPhoneNumberWithoutPreferWithTwoMorePhoneInTheList() {
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.addPhoneNumber(2, new Long(1113));
		psng.addPhoneNumber(3, new Long(1114));
		psng.setCurrentIndex(1);

		Assert.assertEquals(psng.getPhoneNumber(), new Long(1115));
		Assert.assertEquals(psng.getCurrentIndex(), 4);
	}
	
	@Test
	public void testGetPhoneNumberWithoutPreferWithThreeMorePhoneInTheList() {
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.addPhoneNumber(2, new Long(1113));
		psng.addPhoneNumber(3, new Long(1114));
		psng.addPhoneNumber(4, new Long(1118));
		psng.setCurrentIndex(1);

		Assert.assertEquals(psng.getPhoneNumber(), new Long(1115));
		Assert.assertEquals(psng.getCurrentIndex(), 4);
		Assert.assertEquals(psng.getPhoneListSize(), 6);
	}
	
	@Test
	public void testGetPhoneNumberWithPreferNotInUse() {
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.setCurrentIndex(1);

		Assert.assertEquals(psng.getPhoneNumber(new Long(1113), true), new Long(1113));
		Assert.assertEquals(psng.getCurrentIndex(), 2);
	}
	
	@Test
	public void testGetPhoneNumberWithPreferNotInUseNotContinue() {
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.setCurrentIndex(1);

		Assert.assertEquals(psng.getPhoneNumber(new Long(1114), true), new Long(1114));
		Assert.assertEquals(psng.getCurrentIndex(), 1);
	}
	
	@Test
	public void testGetPhoneNumberWithPreferInUseAcceptChange() {
		Long phone = null;
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.setCurrentIndex(1);

		phone = psng.getPhoneNumber(new Long(1112), true);
		Assert.assertEquals(phone, new Long(1113));
		Assert.assertEquals(psng.getCurrentIndex(), 2);
	}	
	
	@Test
	public void testGetPhoneNumberWithPreferInUseNotAcceptChange() {
		Long phone = null;
		PhoneNumberStoreNG psng = new PhoneNumberStoreNGImp();
		psng.addPhoneNumber(0, new Long(1111));
		psng.addPhoneNumber(1, new Long(1112));
		psng.setCurrentIndex(1);

		phone = psng.getPhoneNumber(new Long(1112), false);
		Assert.assertEquals(phone, new Long(0));
		Assert.assertEquals(psng.getCurrentIndex(), 1);
	}	
	
	
}
