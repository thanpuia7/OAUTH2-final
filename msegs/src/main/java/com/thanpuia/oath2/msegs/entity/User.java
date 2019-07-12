package com.thanpuia.oath2.msegs.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User{
	
	
	



	@Id
	@GeneratedValue
	private Integer id;
	
    private String username;
    private String password;
    private String email;
    private String phoneno;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;
    private boolean active;
    
    @Transient
    private String newpassword;
    
    
    
    
    
    
	public User(String username, String password, List<Role> roles, boolean active) {
		
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}


	public User(String password, List<Role> roles, boolean active) {
		
		this.password = password;
		this.roles = roles;
		this.active = active;
	}


	public User(Integer id, String username, String password, List<Role> roles, boolean active) {
	
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}


	





	public User(Integer id, String username, String password, String email, String phoneno, List<Role> roles,
			boolean active, String newpassword) {
	
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
		this.roles = roles;
		this.active = active;
		this.newpassword = newpassword;
	}


	public String getNewpassword() {
		return newpassword;
	}


	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}


	public User(String username, String password, String email, String phoneno, List<Role> roles, boolean active) {
	
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
		this.roles = roles;
		this.active = active;
	}


	public User(Integer id, String username, String password, String email, String phoneno, List<Role> roles,
			boolean active) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
		this.roles = roles;
		this.active = active;
	}


	public User(Integer id, String username, List<Role> roles, boolean active) {
		
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.active = active;
	}


	public User(Integer id, String username) {
		
		this.id = id;
		this.username = username;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public User() {
		
	}
	
	

}
