package repositories;

import domain.User;

public interface UserRepository 
{
	User getUserByUsername(String username);
	void add(User user);
	int count();

}
