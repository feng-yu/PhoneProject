/**
 * 
 */
package com.learning.java.api;

import java.util.ArrayList;

/**
 * @author User
 *
 */
public interface PhoneNumberStoreNG {
	
	public Long getPhoneNumber();
	
	public Long getPhoneNumber(Long preferNumber, boolean acceptChange);
	
	public void addPhoneNumber(int index, Long phoneNumber);
	
	public void setCurrentIndex(int currentIndex);
	
	public int getCurrentIndex();
	
	public int getPhoneListSize();
	
	ArrayList<Long> getPhoneList(); 
}
