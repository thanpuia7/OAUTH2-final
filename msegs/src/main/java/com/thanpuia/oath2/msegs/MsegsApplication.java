package com.thanpuia.oath2.msegs;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thanpuia.oath2.msegs.entity.Role;
import com.thanpuia.oath2.msegs.entity.User;
import com.thanpuia.oath2.msegs.services.UserService;



@SpringBootApplication
public class MsegsApplication {
	
	
	@Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
        	
        
            service.save(new User(1, //id
                   "user1", //username
                    "user", //password
                    "thanpuia@gmail.com",
                    "9158086237",
            	
            		
Arrays.asList(new Role(1,"ADMIN")),//roles 
                    true//Active
            ));
        };
    }   
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }    

	public static void main(String[] args) {
		SpringApplication.run(MsegsApplication.class, args);
	}

}
