package com.utrecht.workingtalentdemo.model;

import javax.persistence.*;

@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    long id;

    String voornaam;
    String achternaam;
    String email;
    String password;
    Boolean adminrights;
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAdminrights() {
		return adminrights;
	}
	public void setAdminrights(Boolean adminrights) {
		this.adminrights = adminrights;
	} 
}
