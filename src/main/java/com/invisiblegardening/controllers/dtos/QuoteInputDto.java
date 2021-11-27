package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.Models.Status;
import com.invisiblegardening.Models.UserData;

import java.util.Date;

public class QuoteInputDto {

    Long id;

    public String description;

    public Date date;

    public Long userDataId;

    public Status status;

    public Quote toQuote() {

        var quote = new Quote();

        quote.setId(id);

        quote.setDescription(description);

        quote.setDate(date);

        return quote;

    }

}
