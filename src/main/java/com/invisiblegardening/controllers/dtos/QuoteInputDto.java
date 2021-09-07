package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.Models.UserData;

import java.util.Date;

public class QuoteInputDto {

    Long id;

    public String description;

    public Date date;

    public Long userDataId;

    public Quote toQuote() {

        var quote = new Quote();

        quote.setId(id);

        quote.setQuoteDescription(description);

        quote.setDate(date);

        return quote;

    }

}
