package com.invisiblegardening.controllers.dtos;

import com.invisiblegardening.Models.Quote;

public class QuoteDto {
    public Long id;

    public String description;

    public static QuoteDto fromQuote(Quote quote) {

        var dto = new QuoteDto();

        dto.id = quote.getId();

        dto.description = quote.getQuoteDescription();

        return dto;

    }

}
