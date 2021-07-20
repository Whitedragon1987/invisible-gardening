package com.invisiblegardening.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    Long id;

    String quoteDescription;

    @Lob
    byte[] situation;

    @OneToMany(mappedBy = "quote")
    List<Request> requestList;

    public Long getId() {
        return id;
    }

    public String getQuoteDescription() {
        return quoteDescription;
    }

    public byte[] getSituation() {
        return situation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuoteDescription(String quoteDescription) {
        this.quoteDescription = quoteDescription;
    }

    public void setSituation(byte[] situation) {
        this.situation = situation;
    }

}
