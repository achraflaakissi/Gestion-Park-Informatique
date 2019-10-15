package org.sidd.service;
import javax.transaction.Transactional; 
import org.sidd.dao.*; 
import org.sidd.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AppRoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User u) {
		u.setPassword(bCryptPasswordEncoder.encode(
		u.getPassword()));
		return userRepository.save(u);
	}
	
	@Override
	public AppRole saveRole(AppRole r) {
		return roleRepository.save(r);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public void addRoleToUser(String username, String roleName) {
		User user=userRepository.findByUsername(username);
		AppRole role=roleRepository.findByRole(roleName);
		user.getRoles().add(role);
	}
}
