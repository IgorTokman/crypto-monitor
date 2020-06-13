package ua.edu.sumdu.cs.igortokman.crypto_monitor.repository;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.Quote;

@Repository
public interface QuoteRepository extends ReactiveCrudRepository<Quote, String> {
    @Tailable
    Flux<Quote> findByTsGreaterThanEqual(long ts);
}
