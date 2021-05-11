package eCommerce.business.concretes;

import eCommerce.business.abstracts.CheckService;
import eCommerce.business.abstracts.UserService;
import eCommerce.core.abstracts.EmailService;
import eCommerce.core.abstracts.SocialServices;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	
	private CheckService checkService;
	private UserDao userDao;
	private EmailService emailService;
	private SocialServices socialServices;

	public UserManager(CheckService checkService,UserDao userDao,EmailService emailService,SocialServices socialServices) {
		super();
		this.checkService = checkService;
		this.userDao = userDao;
		this.emailService = emailService;
		this.socialServices = socialServices;
	}

	@Override
	public void register(User user) {
		
		if(!this.checkService.checkFirstnameAndLastname(user.getFirstName(), user.getLastName())) {
			System.out.println("Check your firstname and lastname - at least 2 char");
			return;
		}
		
		
	    if(!this.checkService.checkEmailFormat(user.getEmail()))
		{
			System.out.println("Check your email please");
			return;
		}
		
		
		if(!this.checkService.checkPassword(user.getPassword())) {
			System.out.println("Check your password - at least 6 char");
			return;
		}
		
	    if(!this.userDao.checkEmail(user)) {
			System.out.println("Check your credentials");
			return;
		}
	    
	    this.emailService.sendEmailToUser(user);
	    this.emailService.linkToVerify(user);
	    
	    this.userDao.add(user);
	    System.out.println("Register Successful");
	    System.out.println("Welcome  "+ user.getFirstName());
		
	}

	@Override
	public void login(String email, String password) {
		
		
		try {
			for(User user: this.userDao.getAll()) {
				if(user.getEmail() == email && user.getPassword() == password) {
					System.out.println("Successful Login:  "+user.getFirstName() +" "+ user.getLastName());
					return;
				
			}
				
			}System.out.println("Error...Check your credentials ");
			}
			
		 catch (Exception e) {
			 e.printStackTrace();
			}
		
	}

	@Override
	public void registerWithOtherService() {
		
		this.socialServices.registerToSystem();
		
	}

}
