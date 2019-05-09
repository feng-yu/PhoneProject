/**
 * 
 */
package com.learning.java.api;

import com.learning.java.Person;

/**
 * @author User
 *
 */
public interface PhoneNumberStore {
	
	/**
	 * Doesn't have prefer number, just return next number from the list
	 * @return long
	 */
	public long getPhoneNumber();
	
	/**
	 * Have prefer number, if the number is not used, return it, 
	 * otherwise, return next available number from list
	 * @param preferPhoneNumber
	 * @param accept
	 * @return
	 */
	public long getPhoneNumber(long preferPhoneNumber, boolean accept);
	
	/**
	 * Enter the owner of a phone number into store.
	 * @param phoneNumber
	 * @param owner
	 * @return
	 */
	public boolean setInformationForPhoneNumber(long phoneNumber, Person owner);
}
