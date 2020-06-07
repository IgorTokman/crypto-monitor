package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.sql.Timestamp;

public interface CryptoQuoteRepository extends MongoRepository<CryptoQuote, String> {}
