package ua.edu.sumdu.cs.igortokman.crypto_monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.CryptoQuoteRepository;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.CryptoQuote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.service.CryptoQuoteService;

import java.time.Duration;

@RestController
public class CryptoController {

    @Autowired
    private CryptoQuoteService cryptoQuoteService;

    @GetMapping(value = "/quotes", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<CryptoQuote> list() {
        return cryptoQuoteService.findBy();
    }
}
