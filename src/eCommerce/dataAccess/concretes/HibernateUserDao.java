package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	public List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		
		this.users.add(user);
		System.out.println(user.getFirstName() +" "+ user.getLastName()+" saved to database");
		
	}

	@Override
	public List<User> getAll() {
		
		return this.users;
	}

	

	@Override
	public boolean checkEmail(User user) {
		for(User person: users) {
			if(person.getEmail() == user.getEmail()) {
				return false;
			}
		}
		
		return true;
	}


}
