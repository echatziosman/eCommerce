package eCommerce.core.abstracts;

import eCommerce.entities.concretes.User;

public interface EmailService {

	void sendEmailToUser(User user);
	void linkToVerify(User user);
}
