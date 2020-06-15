package ua.edu.sumdu.cs.igortokman.crypto_monitor.integration.bitfinex;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Contract {
    public static final String currency = "BTCUSD";
    public static final String exchange = "bitfinex";
    public static final String endpoint = "wss://api-pub.bitfinex.com/ws/2";
    public static final String confirmationRequest =
            "{ \"event\": \"subscribe\",  \"channel\": \"ticker\",  \"symbol\": \"tBTCUSD\" }";
}
