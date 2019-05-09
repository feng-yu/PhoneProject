package com.learning.java.imp;

import java.util.ArrayList;

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
		Long nextPhoneNumber = null;

		if (phoneList.size() == 0) {
			phoneNumber = new Long(1111);
		} else if (currentIndex == phoneList.size() - 1) { // last element in
															// the list
			phoneNumber = phoneList.get(currentIndex) + 1;
			currentIndex++;
		} else {
			phoneNumber = phoneList.get(currentIndex);
			do {
				currentIndex++;
				if (currentIndex != phoneList.size()) {
					if (nextPhoneNumber != null)
						phoneNumber = nextPhoneNumber;
					nextPhoneNumber = phoneList.get(currentIndex);
				} else {
					phoneNumber = nextPhoneNumber;
					break;
				}
			} while (nextPhoneNumber.equals(phoneNumber + 1));

			phoneNumber = phoneNumber + 1;
		}
		phoneList.add(currentIndex, phoneNumber);
		return phoneNumber;
	}

	public Long getPhoneNumber(Long preferNumber, boolean acceptChange) {
		Long phoneNumber = phoneList.get(currentIndex);
		Long nextPhoneNumber;
		int nextIndex;
		boolean inUse = false;

		if (preferNumber <= phoneNumber) {
			inUse = true;
		} else {
			if (currentIndex != phoneList.size() - 1) {
				for (int i = currentIndex + 1; i < phoneList.size(); i++) {
					if (phoneList.get(i) == preferNumber) {
						inUse = true;
					}
				}
			}
		}

		if (inUse) {
			if (acceptChange) {
				if (currentIndex != phoneList.size() - 1) {
					nextIndex = currentIndex + 1;
					nextPhoneNumber = phoneList.get(nextIndex);
					while (nextPhoneNumber == phoneNumber + 1) {
						nextIndex++;
						phoneNumber = nextPhoneNumber;
						nextPhoneNumber = phoneList.get(nextIndex);
					}
					currentIndex = nextIndex;
					phoneNumber = phoneNumber + 1;
				} else {
					currentIndex++;
					phoneNumber = phoneNumber + 1;
				}
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
				phoneNumber = preferNumber;
				phoneList.add(nextIndex, phoneNumber);
			} else {
				currentIndex++;
				phoneNumber = preferNumber;
				phoneList.add(currentIndex, phoneNumber);
			}
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
}
