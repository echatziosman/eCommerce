package eCommerce.core.concretes;

import eCommerce.FacebookRegister.FacebookManager;
import eCommerce.core.abstracts.SocialServices;

public class FacebookManagerAdapter implements SocialServices{

	@Override
	public void registerToSystem() {
		FacebookManager facebookManager = new FacebookManager();
		facebookManager.register();
		
	}

}
