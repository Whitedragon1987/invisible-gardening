package com.invisiblegardening.controllers.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.invisiblegardening.Models.Picture;
import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.Models.UserData;

import java.util.Date;

public class QuoteDto {
    public Long id;

    public String description;

    public Date date;

    @JsonSerialize
    Picture picture;

    @JsonSerialize
    UserDataDto userData;

    public static QuoteDto fromQuote(Quote quote) {

        var dto = new QuoteDto();

        dto.id = quote.getId();

        dto.description = quote.getQuoteDescription();

        dto.date = quote.getDate();

        dto.picture = quote.getPicture();

        dto.userData = UserDataDto.fromUserData(quote.getUserData());

        return dto;

    }

}
