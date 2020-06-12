package ua.edu.sumdu.cs.igortokman.crypto_monitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.CryptoQuote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.CryptoQuoteRepository;

import javax.annotation.PostConstruct;

@Service
public class CryptoQuoteService {

    @Autowired
    private CryptoQuoteRepository cryptoQuoteRepository;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private Logger logger = LoggerFactory.getLogger(CryptoQuoteService.class);

    @PostConstruct
    void configure() {
        reactiveMongoTemplate.dropCollection(CryptoQuote.class)
                .then(
                        reactiveMongoTemplate.createCollection(
                                CryptoQuote.class, CollectionOptions.empty().capped().size(50 * 1024 * 1024).maxDocuments(1000000)
                        )
                ).subscribe();
    }

    public Flux<CryptoQuote> findBy() {
        return cryptoQuoteRepository.findBy();
    }

    public void save(CryptoQuote quote) {
        Mono<CryptoQuote> save = cryptoQuoteRepository.save(quote);
        System.out.println("///////////////");
        System.out.println(save);
        System.out.println("==============");
        save.subscribe();
        System.out.println(save);
        System.out.println("------------");
    }
}