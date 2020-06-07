package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private CryptoQuoteRepository cryptoQuoteRepository;

    @Override
    public void run(String...args) throws Exception {
        CryptoQuote quote = new CryptoQuote();
        quote.setAsk(123.456);
        quote.setBid(789.123);

        cryptoQuoteRepository.save(quote);
    }
}
