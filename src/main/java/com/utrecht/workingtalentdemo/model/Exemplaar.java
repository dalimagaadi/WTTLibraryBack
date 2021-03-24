package com.utrecht.workingtalentdemo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="exemplaar")
public class Exemplaar {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    long id;
	
    String WTid;
    String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWTid() {
		return WTid;
	}

	public void setWTid(String wTid) {
		WTid = wTid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
  
}
