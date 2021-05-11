package eCommerce.core.concretes;

import eCommerce.core.abstracts.EmailService;
import eCommerce.entities.concretes.User;

public class EmailManager implements EmailService{

	@Override
	public void sendEmailToUser(User user) {
		System.out.println("Your verification email has been sent to your email address");
		
	}

	@Override
	public void linkToVerify(User user) {
		System.out.println("Click on the link address to verify");
		
	}

}
