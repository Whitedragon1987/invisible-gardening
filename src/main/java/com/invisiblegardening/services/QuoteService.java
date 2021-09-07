package com.invisiblegardening.services;

import com.invisiblegardening.Models.Quote;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface QuoteService {
    List<Quote> getQuoteList();

    Quote getQuote(Long id);
    Quote saveQuote(Quote quote, Long userDataId);

    void deleteQuote(Long id);
    void assignUserDataToQuote(Long id, Long userDataId);
    void assignPictureToQuote(Long id, Long pictureId);

}
