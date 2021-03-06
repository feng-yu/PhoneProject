package com.learning.java.imp;

import java.util.ArrayList;
import javafx.util.Pair;
import com.learning.java.api.PhoneNumberStoreNG;

public class PhoneNumberStoreNGImp implements PhoneNumberStoreNG {

	static ArrayList<Long> phoneList;
	static int currentIndex;

	public PhoneNumberStoreNGImp() {
		phoneList = new ArrayList<>();
		currentIndex = 0;
	}

	public Long getPhoneNumber() {
		Long phoneNumber = null;
		Pair<Integer, Long> phonePair = null;

		if (phoneList.size() == 0) {
			phoneNumber = new Long(1111);
		} else{
			phonePair = findAvailablePhone();
			currentIndex = phonePair.getKey().intValue();
			phoneNumber = phonePair.getValue();
		}
		phoneList.add(currentIndex, phoneNumber);
		return phoneNumber;
	}

	public Long getPhoneNumber(Long preferNumber, boolean acceptChange) {
		Long phoneNumber = phoneList.get(currentIndex);
		Long nextPhoneNumber;
		int nextIndex;
		boolean inUse = false;
		Pair<Integer, Long> phonePair = null;

		if (preferNumber <= phoneNumber) {
			inUse = true;
		} else {
			if (currentIndex != phoneList.size() - 1) {
				for (int i = currentIndex + 1; i < phoneList.size(); i++) {
					if (phoneList.get(i).equals(preferNumber)) {
						inUse = true;
					}
				}
			}
		}

		if (inUse) {
			if (acceptChange) {
				phonePair = findAvailablePhone();
				currentIndex = phonePair.getKey().intValue();
				phoneNumber = phonePair.getValue();
				phoneList.add(currentIndex, phoneNumber);
			} else {
				phoneNumber = new Long(0);
			}
		} else {
			if (currentIndex != phoneList.size() - 1) {
				nextIndex = currentIndex + 1;
				nextPhoneNumber = phoneList.get(nextIndex);
				while (preferNumber > nextPhoneNumber) {
					nextIndex++;
					nextPhoneNumber = phoneList.get(nextIndex);
				}
				
				phoneList.add(nextIndex, preferNumber);
			} else {
				if (phoneNumber == preferNumber - 1){
					phoneList.add(currentIndex++, preferNumber);
				}else {
					phoneList.add(currentIndex + 1, preferNumber);				
				}
			}
			phoneNumber = preferNumber;
		}

		return phoneNumber;
	}

	public void addPhoneNumber(int index, Long phoneNumber) {
		phoneList.add(index, phoneNumber);
	}

	public void setCurrentIndex(int index) {
		PhoneNumberStoreNGImp.currentIndex = index;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public int getPhoneListSize() {
		return phoneList.size();
	}

	public ArrayList<Long> getPhoneList() {
		return phoneList;
	}

	private Pair<Integer, Long> findAvailablePhone() {
		Pair<Integer, Long> phonePair = null;
		Long phoneNumber = null;
		Long nextPhoneNumber = null;
		int cIndex = 0;
		
		cIndex = currentIndex;
		phoneNumber = phoneList.get(cIndex);
		
		if (cIndex == phoneList.size() - 1) { // last element in the list
			phoneNumber = phoneNumber + 1;
			cIndex ++;
		} else {
			do {
				cIndex++;
				if (cIndex != phoneList.size()) {
					if (nextPhoneNumber != null)
						phoneNumber = nextPhoneNumber;
					nextPhoneNumber = phoneList.get(cIndex);
				} else {
					phoneNumber = nextPhoneNumber;
					break;
				}
			} while (nextPhoneNumber.equals(phoneNumber + 1));

			phoneNumber = phoneNumber + 1;
		}
		phonePair = new Pair<Integer, Long>(new Integer(cIndex), new Long(phoneNumber));
		return phonePair;
	}
}
