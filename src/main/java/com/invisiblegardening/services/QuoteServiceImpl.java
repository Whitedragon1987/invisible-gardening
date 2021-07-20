package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {
    private QuoteRepository quoteRepository;


    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {

        this.quoteRepository = quoteRepository;

    }

    @Override
    public List<Quote> getQuoteList() {

        return quoteRepository.findAll();

    }

    @Override
    public Quote getQuote(Long id) {

        var optionalQuote = quoteRepository.findById(id);

        if (optionalQuote.isPresent()) {

            return optionalQuote.get();

        } else {

            throw new RecordNotFoundException("no quote was found");

        }

    }

    @Override
    public Quote saveQuote(Quote quote) {

        return quoteRepository.save(quote);

    }

    @Override
    public void deleteQuote(Long id) {

        quoteRepository.deleteById(id);

    }

    @Override
    public void uploadSituation(Long id, MultipartFile file) throws IOException {

        var optionalQuote = quoteRepository.findById(id);

        if (optionalQuote.isPresent()) {

            var quote = optionalQuote.get();

            quote.setSituation(file.getBytes());

            quoteRepository.save(quote);

        } else {

            throw new RecordNotFoundException("no file was uploaded");

        }

    }

    @Override
    public byte[] getImage(Long id) {

        var optionalQuote = quoteRepository.findById(id);

        if (optionalQuote.isPresent()) {

            return optionalQuote.get().getSituation();

        } else {

            throw new RecordNotFoundException("no file was found");

        }

    }

}
