package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
public class CryptoController {

    private final CryptoQuoteService quoteService;

    public CryptoController(CryptoQuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes/{id}")
    public Mono<CryptoQuote> find(@PathVariable("id") String id) {
        return quoteService.findById(Integer.parseInt(id));
    }

    @GetMapping(value = "/quotes", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<CryptoQuote> list() {
        return quoteService.findAll();
    }
}
