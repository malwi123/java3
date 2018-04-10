package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.User;


public class DummyUserRepository  implements UserRepository
{
	public static List<User> db = new ArrayList<User>();
		
	@Override
	public User getUserByUsername(String username) {
		
		for(User user: db)
		{
			if(user.getUsername().equalsIgnoreCase(username))
				return user;
		}
		
		return null;
	}

	@Override
	public void add(User user) {
		db.add(user);	
	}
	
	@Override
	public int count() {
		return db.size();
	}

}

