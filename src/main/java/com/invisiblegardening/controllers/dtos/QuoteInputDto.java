package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Quote;

public class QuoteInputDto {

    Long id;

    public String description;

    public Quote toQuote() {

        var quote = new Quote();

        quote.setId(id);

        quote.setQuoteDescription(description);

        return quote;

    }

}
