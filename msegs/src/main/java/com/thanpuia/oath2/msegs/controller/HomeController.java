package com.thanpuia.oath2.msegs.controller;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thanpuia.oath2.msegs.entity.Role;
import com.thanpuia.oath2.msegs.entity.User;
import com.thanpuia.oath2.msegs.repository.UserRepository;
import com.thanpuia.oath2.msegs.services.UserService;






@RestController
public class HomeController {
	
	
	
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private UserRepository repo;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	 

    @GetMapping(value = "/")
    public String index(){
        return "Hello world";
    }

    @GetMapping(value = "/private")
    public String privateArea(){
        return "Private area";
    }


 
 
  @PostMapping(value = "/add")
	public String addUserByAdmin(@RequestBody User user) {

    	if(userService.findUser(user.getUsername()))
    		
    		return "Exist";
    	else
    	{
userService.save(new User(
				
			
                user.getUsername(), //username
                user.getPassword(), //password
                user.getEmail(),
                user.getPhoneno(),
                
        	
        		
Arrays.asList(new Role("USER")),//roles 
                true//Active
                
		 ));
		

		return "user added successfully...";
	}
    	
    }
  
  
  
  
 // @PreAuthorize("hasAnyRole('ADMIN')")
  @GetMapping(value = "/view/{username}")
  public Optional<User> viewProfile(@PathVariable String username) {
	  
	 return userService.findByusername(username);
	  
	  
	  
  }
  
  
  

	/*
	 * @PutMapping(value = "/update/{id}") public String updateUser(@RequestBody
	 * User user, @PathVariable Integer id) {
	 * 
	 * 
	 * Optional<User> user11=repo.findById(user.getId()); User user22=user11.get();
	 * 
	 * 
	 * Optional<User> user1=userService.findByusername(user.getUsername()); User
	 * user2=user1.get();
	 * 
	 * if(userService.findUser(user.getUsername())) { if(id!=user2.getId())
	 * 
	 * return "Exist";
	 * 
	 * else { user22.setUsername(user.getUsername()); repo.save(user22); }
	 * 
	 * return "user updated successfully...";
	 * 
	 * 
	 * }
	 * 
	 * user22.setUsername(user.getUsername()); repo.save(user22);
	 * 
	 * 
	 * return "user updated successfully...";
	 * 
	 * }
	 */
  
  @PostMapping(value = "/update")
	public String userUpdate(@RequestBody User user) {
	  
	  
	  Optional<User> user11=repo.findById(user.getId());
	  User user22=user11.get();

  	if(userService.findUser(user.getUsername()) && user.getId()!=user22.getId())
  		                                                                                                                               
  		 return "Exist";
  	
  	
  	else
  	{
repo.save(new User(
				
			  user.getId(),
            user.getUsername(), //username
            user22.getPassword(), //password
            user.getEmail(),
            user.getPhoneno(),
              
      	
      		
Arrays.asList(new Role("USER")),//roles 
             true//Active
              
		 ));
		

		return "user updated successfully...";
	}
  	
  }
  
  
  
  
  @PostMapping(value = "/changePass/{newpassword}")
	public String changePass(@RequestBody User user,@PathVariable String  newpassword) {
	  
	  
	  Optional<User> user11=repo.findById(user.getId());
	  User user22=user11.get();
	  
	  
	  boolean result = passwordEncoder.matches(user.getPassword(), user22.getPassword());
	 
	  if(result)
	  { 
		 
		  
		  user22.setPassword(passwordEncoder.encode(newpassword));
		  
		  repo.save(user22);
		  
		  return "Password updated successfully";
		  
	  }
	  
	  else 
		  
		System.out.println(user.getPassword());
	  	System.out.println(passwordEncoder.encode(user.getPassword()));
	  	System.out.println(user22.getPassword());
	  	
	  	System.out.println(user.getId());
	  	System.out.println(newpassword);
	  	
	  	
		  return "Password not match";
			  
	  
	 
}


  
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    } 
}
