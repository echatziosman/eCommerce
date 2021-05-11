package eCommerce.core.concretes;

import eCommerce.GoogleRegister.GoogleManager;
import eCommerce.core.abstracts.SocialServices;

public class GoogleManagerAdapter implements SocialServices{


	@Override
	public void registerToSystem() {
		GoogleManager googleManager = new GoogleManager();
		googleManager.register();
	}

}
