package com.thanpuia.oath2.msegs.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thanpuia.oath2.msegs.entity.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
  
	
	public Optional<User> findByUsername(String username);
    
    
}
