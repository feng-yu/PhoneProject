/**
 * 
 */
package com.learning.java;

/**
 * @author User
 *
 */
public class Person {
	
	String fName;
	String lName;
	String address;
	
	/**
	 * 
	 */
	public Person(String fName, String lName, String address) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		
	}
	
	public Person(){
		
	}
	
	@Override
	public String toString(){
		return fName + " " + lName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getAddress() {
		return address;
	}
	


}
