package com.invisiblegardening.controllers;

import com.invisiblegardening.Exceptions.BadRequestException;
import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.controllers.dtos.QuoteDto;
import com.invisiblegardening.controllers.dtos.QuoteInputDto;
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

        var quote = quoteService.saveQuote(dto.toQuote());

        return QuoteDto.fromQuote(quote);

    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable("id") Long id) {

        quoteService.deleteQuote(id);

    }

    @PostMapping("/{id}/license")
    public void uploadSituation(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {

        List<String> whitelist = new ArrayList<>();

        whitelist.add("application/gif");

        whitelist.add("application/jpe");

        whitelist.add("application/jpeg");

        boolean valid = false;

        for (String s : whitelist) {

            if (file.getContentType().equals(s)) {

                valid = true;

                break;

            }

        }

        if (file.getContentType() == null || !valid) {

            throw new BadRequestException();

        }

        quoteService.uploadSituation(id, file);

    }

    @GetMapping("/{id}/situation")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {

        var situationBytes = quoteService.getImage(id);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment").body(situationBytes);

    }

}