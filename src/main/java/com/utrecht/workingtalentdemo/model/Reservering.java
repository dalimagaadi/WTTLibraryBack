package com.utrecht.workingtalentdemo.model;

import javax.persistence.*;

@Entity(name="Reservering")
public class Reservering {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    long id;

    @OneToOne
    Exemplaar exemplaar;

    // isbn om makkelijker te queryen om welke boek het gaat?
    String isbn;
    String reserveringsDatum;

    public long getId() {
        return id;
    }

    public Exemplaar getExemplaar() {
        return exemplaar;
    }

    public void setExemplaar(Exemplaar exemplaar) {
        this.exemplaar = exemplaar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String _isbn) {
        isbn = _isbn;
    }

    public String getReserveringsDatum() {
        return reserveringsDatum;
    }

    public void setReserveringsDatum(String status) {
        this.reserveringsDatum = status;
    }

}
