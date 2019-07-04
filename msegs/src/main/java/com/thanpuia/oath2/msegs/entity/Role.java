package com.thanpuia.oath2.msegs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role{
	
	
	@Id
	@GeneratedValue
	private Integer id;
    private String name;

	public Role(String name) {
	
		this.name = name;
	}

	public Role(Integer id, String name) {
	
		this.id = id;
		this.name = name;
	}

	public Role() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
    
}
