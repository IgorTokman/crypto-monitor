package ua.edu.sumdu.cs.igortokman.crypto_monitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.Quote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.QuoteRepository;

import javax.annotation.PostConstruct;

@Service
public class TradingService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @PostConstruct
    void configure() {
        reactiveMongoTemplate.dropCollection(Quote.class)
                .then(
                        reactiveMongoTemplate.createCollection(
                                Quote.class, CollectionOptions.empty().capped().size(50 * 1024 * 1024).maxDocuments(1000000)
                        )
                ).subscribe();
    }

    public Flux<Quote> findQuotesAfter(long timeMillis) {
        return quoteRepository.findByTsGreaterThanEqual(timeMillis);
    }

    public void save(Quote quote) {
        quoteRepository.save(quote).subscribe();
    }
}