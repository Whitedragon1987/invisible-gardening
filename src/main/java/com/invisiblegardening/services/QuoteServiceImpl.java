package com.invisiblegardening.services;

import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.repositories.PictureRepository;
import com.invisiblegardening.repositories.QuoteRepository;
import com.invisiblegardening.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {
    private QuoteRepository quoteRepository;
    private PictureRepository pictureRepository;
    private UserDataRepository userDataRepository;


    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository,
                            PictureRepository pictureRepository,
                            UserDataRepository userDataRepository) {

        this.quoteRepository = quoteRepository;
        this.pictureRepository = pictureRepository;
        this.userDataRepository = userDataRepository;

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
    public Quote saveQuote(Quote quote, Long userDataId) {

        var optionalUserData = userDataRepository.findById(userDataId);

        if (optionalUserData.isPresent()) {
            var userData = optionalUserData.get();

            quote.setUserData(userData);

            return quoteRepository.save(quote);

        } else {

            throw new RecordNotFoundException();

        }
    }

    @Override
    public void deleteQuote(Long id) {

        quoteRepository.deleteById(id);

    }


    @Override
    public void assignPictureToQuote(Long id, Long pictureId) {

        var optionalQuote = quoteRepository.findById(id);

        var optionalPicture = pictureRepository.findById(pictureId);

        if (optionalQuote.isPresent() && optionalPicture.isPresent()) {

            var quote = optionalQuote.get();

            var picture = optionalPicture.get();

            quote.setPicture(picture);

            quoteRepository.save(quote);

        } else {

            throw new RecordNotFoundException();

        }

    }

    @Override
    public void assignUserDataToQuote(Long id, Long userDataId) {

        var optionalQuote = quoteRepository.findById(id);

        var optionalUserData = userDataRepository.findById(userDataId);

        if (optionalQuote.isPresent() && optionalUserData.isPresent()) {

            var quote = optionalQuote.get();

            var userData = optionalUserData.get();

            quote.setUserData(userData);

            quoteRepository.save(quote);

        } else {

            throw new RecordNotFoundException();

        }

    }

}
