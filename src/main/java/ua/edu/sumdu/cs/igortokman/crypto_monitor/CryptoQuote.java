package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@Document(collection="quotes")
public class CryptoQuote implements Serializable {
    @Id
    private String id;
    private String exchange;
    private Timestamp ts;
    private String currency;
    private double bid;
    private double ask;
    private double last_price;
    private double volume;
    private double high;
}
