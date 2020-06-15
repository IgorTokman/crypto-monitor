package ua.edu.sumdu.cs.igortokman.crypto_monitor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="quotes")
public class Quote {
    @Id
    @JsonIgnore
    private String id;
    private String exchange;
    private long ts;
    private String currency;
    private double bid;
    private double ask;
    @JsonIgnore
    private double last_price;
    @JsonIgnore
    private double volume;
    @JsonIgnore
    private double high;
    @JsonIgnore
    private double low;
}
