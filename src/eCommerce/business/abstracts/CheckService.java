package eCommerce.business.abstracts;


public interface CheckService {

	boolean checkFirstnameAndLastname(String firstName,String lastName);
	boolean checkEmailFormat(String email);
	boolean checkPassword(String password);
}
