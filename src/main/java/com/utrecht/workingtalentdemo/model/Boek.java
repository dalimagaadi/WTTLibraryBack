package com.utrecht.workingtalentdemo.model;

import java.util.List;

import javax.persistence.*;

@Entity(name="boek")
public class Boek {
    @Id
    @Column(name = "ISBN")
    private String ISBN;

    private String titel;
    private String auteur;
    private String tags;
    private String status;
    private int aantal;

    @OneToMany
    List<Exemplaar> exemplaren;
    

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

	public List<Exemplaar> getExemplaren() {
		return exemplaren;
	}

	public void setExemplaren(List<Exemplaar> exemplaren) {
		this.exemplaren = exemplaren;
	}
}
