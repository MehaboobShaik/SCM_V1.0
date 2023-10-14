package com.SmartContactManager_2.Repository;


import com.SmartContactManager_2.model.User;

public interface UserRepository{

	public int registerUser(User user);
    
	public User getUserByEmail(String email);
	
}
