package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Autowired
    private CryptoQuoteRepository cryptoQuoteRepository;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${crypto.ticker.symbol}")
    private String symbol;

    @Override
    public void run(String...args) throws Exception {

        CryptoQuote quote = new CryptoQuote();
//        quote.setAsk(123.456);
//        quote.setBid(789.123);

        cryptoQuoteRepository.save(quote);
    }
}
