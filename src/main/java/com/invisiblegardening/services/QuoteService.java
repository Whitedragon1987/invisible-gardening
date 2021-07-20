package com.invisiblegardening.services;

import com.invisiblegardening.Models.Quote;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface QuoteService {
    List<Quote> getQuoteList();

    Quote getQuote(Long id);
    Quote saveQuote(Quote quote);

    void deleteQuote(Long id);
    void uploadSituation(Long id, MultipartFile file) throws IOException;

    byte[] getImage(Long id);
}
