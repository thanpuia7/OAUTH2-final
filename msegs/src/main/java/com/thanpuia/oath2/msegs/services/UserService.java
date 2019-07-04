package com.thanpuia.oath2.msegs.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thanpuia.oath2.msegs.entity.User;
import com.thanpuia.oath2.msegs.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

	public boolean findUser(String username) {
		
		if(repo.findByUsername(username).isPresent())
			return true;
			
		else
			return false;
			
		
	}

	public Optional<User> findByusername(String username) {
		
		return repo.findByUsername(username);
	}
	
}
