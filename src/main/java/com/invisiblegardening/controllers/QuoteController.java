package com.invisiblegardening.controllers;

import com.invisiblegardening.Exceptions.BadRequestException;
import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.controllers.dtos.*;
import com.invisiblegardening.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {

        this.quoteService = quoteService;

    }

    @GetMapping
    public List<QuoteDto> getQuoteList() {

        var dtos = new ArrayList<QuoteDto>();

        var quoteList = quoteService.getQuoteList();

        for (Quote quote : quoteList) {

            dtos.add(QuoteDto.fromQuote(quote));

        }

        return dtos;

    }

    @GetMapping("/{id}")
    public QuoteDto getQuote(@PathVariable("id") Long id) {

        var quote = quoteService.getQuote(id);

        return QuoteDto.fromQuote(quote);

    }

    @PostMapping
    public QuoteDto saveQuote(@RequestBody QuoteInputDto dto) {

        var quote = quoteService.saveQuote(dto.toQuote(), dto.userDataId);

        return QuoteDto.fromQuote(quote);

    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable("id") Long id) {

        quoteService.deleteQuote(id);

    }


    @PutMapping("/{id}")
    public QuoteDto updateRequest(@PathVariable("id") Long id, @RequestBody QuoteInputDto dto) {

        quoteService.updateQuote(id, dto);
        var quote = quoteService.getQuote(id);

        return QuoteDto.fromQuote(quote);
    }

    @PostMapping("/quote/{id}/picture")
    public void assignPictureToQuote(@PathVariable("id") Long quoteId, @RequestBody IdInputDto input) {

        quoteService.assignPictureToQuote(quoteId, input.id);
    }

    @PostMapping("/{id}/userdata")
    public void assignUserDataToQuote(@PathVariable("id") Long quoteId, @RequestBody IdInputDto input) {

        quoteService.assignUserDataToQuote(quoteId, input.id);
    }
}