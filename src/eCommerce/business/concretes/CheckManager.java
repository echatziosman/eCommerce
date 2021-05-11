package eCommerce.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerce.business.abstracts.CheckService;

public class CheckManager implements CheckService{

	@Override
	public boolean checkFirstnameAndLastname(String firstName, String lastName) {
		
		if(firstName.length() >= 2 && lastName.length() >= 2) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean checkEmailFormat(String email) {
		
		boolean status = false;
		 String REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		 
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(email);

		if (m.matches()) {
			status = true;
		}
		else {
			status = false;
		}
		return status;
		    
	}

	@Override
	public boolean checkPassword(String password) {
		
		if(password.length() >= 6) {
			return true;
		}
		else {
			return false;
		}
			
	}

	
	

}
