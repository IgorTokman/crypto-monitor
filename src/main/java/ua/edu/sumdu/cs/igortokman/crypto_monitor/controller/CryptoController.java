package ua.edu.sumdu.cs.igortokman.crypto_monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.QuoteRepository;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.Quote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.service.TradingService;

@RestController
public class CryptoController {

    @Autowired
    private TradingService tradingService;

    @GetMapping(value = "/trading-events", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Quote> findLast() {
        return tradingService.findQuotesAfter(System.currentTimeMillis());
    }

    @GetMapping(value = "/")
    public String test() {
        return "testing";
    }
}
