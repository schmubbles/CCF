package TestCases;

import objectLayer.Admin;

public class AdminTests {
	
	private String errorMessage;
	
	/**
	 * Get the errorMessage if test() returned false
	 * @return the string holding the error message
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	/**
	 * Test the validity of the Admin class
	 * @return true if all getters, setters, and constructors work for Admin. 
	 * False if one or more fail, and the error message is store in errorMessage.
	 */
	public boolean test() {
		boolean ret = true;
		if (ret = testId() == false) {
			return ret;
		} else if (ret = testFName() == false) {
			return ret;
		} else if (ret = testLName() == false) {
			return ret;
		} else if (ret = testUsername() == false) {
			return ret;
		} else if (ret = testPassword() == false) {
			return ret;
		} else if (ret = testEmail() == false) {
			return ret;
		} else if (ret = testType() == false) {
			return ret;
		}
		
		return ret;
	}
	
	private boolean testId() {
		boolean ret = true;
		Admin a = new Admin(2, "fName", "lName", "username", "password", "email", 1);
		if (a.getId() != 2) {
			ret = false;
			errorMessage = "Constructor Id doesn't return as expected.";
		} 
		a.setId(1);
		if (a.getId() != 1) {
			ret = false;
			errorMessage = "setId doesn't return as expected.";
		}
		return ret;
	}
	
	private boolean testFName() {
		boolean ret = true;
		Admin a = new Admin(0, "fName", "lName", "username", "password", "email", 1);
		if (a.getfName().compareTo("fName") != 0){
			ret = false;
			errorMessage = "Constructor fName doesn't return as expected.";
		}
		a.setfName("AnotherFName");
		if(a.getfName().compareTo("AnotherFName") != 0) {
			ret = false;
			errorMessage = "setfName doesn't return as expected"; 
		}
		return ret;	
	}
	
	private boolean testLName() {
		boolean ret = true;
		Admin a = new Admin(0, "fName", "lName", "username", "password", "email", 1);
		if (a.getlName().compareTo("lName") != 0){
			ret = false;
			errorMessage = "Constructor lName doesn't return as expected.";
		}
		a.setlName("AnotherLName");
		if(a.getlName().compareTo("AnotherLName") != 0) {
			ret = false;
			errorMessage = "setlName doesn't return as expected"; 
		}
		return ret;	
	}

	private boolean testUsername() {
		boolean ret = true;
		Admin a = new Admin(0, "fName", "lName", "username", "password", "email", 1);
		if (a.getUsername().compareTo("username") != 0){
			ret = false;
			errorMessage = "Constructor username doesn't return as expected.";
		}
		a.setUsername("AnotherUsername");
		if(a.getUsername().compareTo("AnotherUsername") != 0) {
			ret = false;
			errorMessage = "setUsername doesn't return as expected"; 
		}
		return ret;	
	}
	
	private boolean testPassword() {
		boolean ret = true;
		Admin a = new Admin(0, "fName", "lName", "username", "password", "email", 1);
		if (a.getPassword().compareTo("password") != 0){
			ret = false;
			errorMessage = "Constructor password doesn't return as expected.";
		}
		a.setPassword("AnotherPassword");
		if(a.getPassword().compareTo("AnotherPassword") != 0) {
			ret = false;
			errorMessage = "Password doesn't return as expected"; 
		}
		return ret;	
	}
	
	private boolean testEmail() {
		boolean ret = true;
		Admin a = new Admin(0, "fName", "lName", "username", "password", "email", 1);
		if (a.getEmail().compareTo("email") != 0){
			ret = false;
			errorMessage = "Constructor email doesn't return as expected.";
		}
		a.setEmail("AnotherEmail");
		if(a.getEmail().compareTo("Email") != 0) {
			ret = false;
			errorMessage = "setEmail doesn't return as expected"; 
		}
		return ret;	
	}

	private boolean testType() {
		boolean ret = true;
		Admin a = new Admin(2, "fName", "lName", "username", "password", "email", 1);
		if (a.getType() != 1) {
			ret = false;
			errorMessage = "Constructor Type doesn't return as expected.";
		} 
		a.setType(2);
		if (a.getType() != 2) {
			ret = false;
			errorMessage = "setType doesn't return as expected.";
		}
		return ret;
	}
}


