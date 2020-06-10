package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class Ticker {

    @Autowired
    private CryptoQuoteRepository cryptoQuoteRepository;

    @Value("${crypto.ticker.symbol}")
    private String symbol;

    WebClient.RequestHeadersSpec<?> request = WebClient
            .create("https://api.bitfinex.com/v1/pubticker/bttbtc")
            .get();

    private Logger logger = LoggerFactory.getLogger(Ticker.class);

    @Scheduled(fixedRate = 5000L)
    public void scheduleTradeEvents() throws InterruptedException {
        CryptoQuote quote = request.exchange().block().bodyToMono(CryptoQuote.class).block();

        logger.info(String.valueOf(quote));

        cryptoQuoteRepository.save(quote);
        logger.info("===================");
    }

}
