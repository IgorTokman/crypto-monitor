package ua.edu.sumdu.cs.igortokman.crypto_monitor.helper;

import com.google.gson.Gson;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.CryptoQuote;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TickerConverter {

    // Trading pairs
    // [CHANNEL_ID,[BID,BID_SIZE,ASK,ASK_SIZE,DAILY_CHANGE,DAILY_CHANGE_RELATIVE,LAST_PRICE,VOLUME,HIGH,LOW]]
    Pattern pattern = Pattern.compile("(?<bid>-?\\d+(?:\\.\\d+)?),(?<bidsize>-?\\d+(?:\\.\\d+)?)," +
            "(?<ask>-?\\d+(?:\\.\\d+)?),(?<asksize>-?\\d+(?:\\.\\d+)?)," +
            "(?<dailychange>-?\\d+(?:\\.\\d+)?),(?<dailychangerelative>-?\\d+(?:\\.\\d+)?)," +
            "(?<lastprice>-?\\d+(?:\\.\\d+)?),(?<volume>-?\\d+(?:\\.\\d+)?)," +
            "(?<high>-?\\d+(?:\\.\\d+)?),(?<low>-?\\d+(?:\\.\\d+)?)]]");

    public CryptoQuote map(String json) {
        if (!json.endsWith("]]")) { return  null; }
        Matcher matcher = pattern.matcher(json);

        CryptoQuote result = null;
        while (matcher.find()) {
            result = CryptoQuote.builder()
                    .currency("BTCUSD")
                    .exchange("bitfinex")
                    .ts(new Timestamp(System.currentTimeMillis()))
                    .bid(Double.parseDouble(matcher.group("bid")))
                    .ask(Double.parseDouble(matcher.group("ask")))
                    .last_price(Double.parseDouble(matcher.group("lastprice")))
                    .volume(Double.parseDouble(matcher.group("volume")))
                    .high(Double.parseDouble(matcher.group("high")))
                    .low(Double.parseDouble(matcher.group("low"))).build();
        }

        return result;
    }
}
