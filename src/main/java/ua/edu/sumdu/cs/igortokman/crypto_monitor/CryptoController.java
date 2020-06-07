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

    public CryptoController() {
    }

    @GetMapping("/quotes/{id}")
    public Mono<CryptoQuote> find(@PathVariable("id") String id) {
        return Mono.just(new CryptoQuote());
    }

    @GetMapping(value = "/quotes", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<CryptoQuote> list() {
        return Flux.just(new CryptoQuote());
    }
}
