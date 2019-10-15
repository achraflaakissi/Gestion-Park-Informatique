package org.sidd.service;

import org.sidd.entites.User;
import org.sidd.entites.AppRole;;

public interface AccountService {
	public User saveUser(User u);
	public AppRole saveRole(AppRole r);
	public User findUserByUsername(String username);
	public void addRoleToUser(String username,String role);
}
