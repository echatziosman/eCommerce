package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface UserService {

	void register(User user);
	void login(String email,String password);
	void registerWithOtherService();
}