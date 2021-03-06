package com.invisiblegardening.services;

import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.controllers.dtos.QuoteInputDto;

import java.util.List;

public interface QuoteService {
    List<Quote> getQuoteList();

    Quote getQuote(Long id);
    Quote saveQuote(Quote quote, Long userDataId);

    void deleteQuote(Long id);
    Quote updateQuote(Long id, QuoteInputDto dto);
    void assignUserDataToQuote(Long id, Long userDataId);
    void assignPictureToQuote(Long id, Long pictureId);

}
