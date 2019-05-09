/**
 * 
 */
package com.learning.java.imp;

import java.util.Hashtable;

import com.learning.java.Person;
import com.learning.java.api.PhoneNumberStore;

/**
 * @author User
 *
 */
public class PhoneNumberStoreImp implements PhoneNumberStore {
	private static long currentPosition;

	Hashtable<Long, Person> phoneNumberTable;

	/**
	 * By default, store number from 0000000000 to 000999999999
	 */
	public PhoneNumberStoreImp() {
		phoneNumberTable = new Hashtable<>();
		
		for (int i = 1111111; i <= 9999999; i++) {
			phoneNumberTable.put(new Long(i), new Person());
		}
		currentPosition = 1111111;
	}

	public PhoneNumberStoreImp(int areaCode) {
		for (int i = 1111111; i <= 9999999; i++) {
			long pn = areaCode * 100000000 + i;
			phoneNumberTable.put(pn, null);
		}
		currentPosition = areaCode * 100000000 + 1111111;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.java.api.PhoneNumberStore#getPhoneNumber()
	 */
	@Override
	public long getPhoneNumber() {
		long phoneNumber;

		while (phoneNumberTable.get(currentPosition).getfName() != null) {
			currentPosition++;
		}
		phoneNumber = currentPosition;

		do {
			currentPosition++;
		} while (phoneNumberTable.get(currentPosition).getfName() != null);

		return phoneNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.java.api.PhoneNumberStore#getPhoneNumber(long)
	 */
	@Override
	public long getPhoneNumber(long preferPhoneNumber, boolean accept) {
		if (accept) {
			while (phoneNumberTable.get(preferPhoneNumber).getfName() != null) {
				preferPhoneNumber++;
			}			
		} else {
			if (phoneNumberTable.get(preferPhoneNumber).getfName() != null)
				preferPhoneNumber = 0;
		}
		return preferPhoneNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.learning.java.api.PhoneNumberStore#setInformationForPhoneNumber(long,
	 * com.learning.java.Person)
	 */
	@Override
	public boolean setInformationForPhoneNumber(long phoneNumber, Person owner) {
		phoneNumberTable.put(phoneNumber,  owner);
		return true;
	}

	public static synchronized long getCurrentPosition() {
		return currentPosition;
	}

	public static synchronized void setCurrentPosition(long currentPosition) {
		PhoneNumberStoreImp.currentPosition = currentPosition;
	}

}
