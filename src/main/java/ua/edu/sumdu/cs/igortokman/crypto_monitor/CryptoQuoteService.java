package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CryptoQuoteService {

    public static final int GENERAL_CRYPTO_QUOTE_AMOUNT = 10;
    private final HashMap<String, CryptoQuote> quotes = new HashMap<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < GENERAL_CRYPTO_QUOTE_AMOUNT; i++) {
            quotes.put(String.valueOf(i), new CryptoQuote(i));
        }
    }

    public Mono<CryptoQuote> findById(int id) {
        return Mono.justOrEmpty(quotes.get(String.valueOf(id)));
    }

    public Flux<CryptoQuote> findAll() {
        return Flux.fromIterable(quotes.values()).delayElements(Duration.ofSeconds(1));
    }

    public Mono<CryptoQuote> save(Mono<CryptoQuote> quote) {
        return quote.map(this::save);
    }

    private CryptoQuote save(CryptoQuote quote) {
        quotes.put(String.valueOf(quote.getId()), quote);
        return quote;
    }
}
