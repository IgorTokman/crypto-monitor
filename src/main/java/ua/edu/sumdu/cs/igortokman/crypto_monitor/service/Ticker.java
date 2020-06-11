package ua.edu.sumdu.cs.igortokman.crypto_monitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.CryptoQuote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.CryptoQuoteRepository;

@Service
public class Ticker {

    @Autowired
    private CryptoQuoteRepository cryptoQuoteRepository;

    @Value("${crypto.ticker.symbol}")
    private String symbol;

    WebClient.RequestHeadersSpec<?> request = WebClient
            .create("https://api.bitfinex.com/v1/pubticker/bttbtc")
            .get();

    private Logger logger = LoggerFactory.getLogger(Ticker.class);

    private int index = 0;

    @Scheduled(fixedRate = 5000L)
    public void scheduleTradeEvents() throws InterruptedException {
        CryptoQuote quote = request.exchange().block().bodyToMono(CryptoQuote.class).block();
        quote.setExchange(String.valueOf(++index));
        cryptoQuoteRepository.save(quote).subscribe();

        cryptoQuoteRepository.findAll().subscribe(/*item -> logger.info("{}", item)*/);
    }
}
