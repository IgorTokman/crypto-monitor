package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;

@RestController
public class CryptoController {

    @Autowired
    private CryptoQuoteRepository cryptoQuoteRepository;

    @GetMapping(value = "/quotes", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<CryptoQuote> list() {
        return cryptoQuoteRepository.findAll().delayElements(Duration.ofSeconds(4));
    }
}
