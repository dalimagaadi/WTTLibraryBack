package com.utrecht.workingtalentdemo.model;

import javax.persistence.*;

@Entity(name="exemplaar")
public class Exemplaar {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    long id;
	
    String wtid;
    String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWtid() {
		return wtid;
	}

	public void setWtid(String wTid) {
		wtid = wTid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
  
}
