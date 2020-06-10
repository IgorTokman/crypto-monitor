package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CryptoQuoteRepository extends ReactiveCrudRepository<CryptoQuote, String> {}
