package com.SmartContactManager_2.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role{

	@Id
	private Integer role_id;
    private String name;
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
	
}
