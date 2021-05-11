package eCommerce;

import eCommerce.business.abstracts.UserService;
import eCommerce.business.concretes.CheckManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.concretes.EmailManager;
import eCommerce.core.concretes.FacebookManagerAdapter;
import eCommerce.dataAccess.concretes.HibernateUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
	
		UserService userService = new UserManager(new CheckManager(), new HibernateUserDao(), new EmailManager(),new FacebookManagerAdapter());
		
		User user = new User(1,"Enes","Chatziosman","e.chatziosman@gmail.com","123456");
		User user1 = new User(2,"John","Doe","jdoe@gmail.com","123456");
		
		//userService.register(user);
		userService.register(user1);
		userService.login("e.chatziosman@gmail.com","123456");
		
		System.out.println("**************Register with the other account**************");
		
		userService.registerWithOtherService();
		
		
		
	}

}
