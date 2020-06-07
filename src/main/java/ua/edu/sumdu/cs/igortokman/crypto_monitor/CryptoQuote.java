package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

public class CryptoQuote {
    private int id;

    public CryptoQuote(int id) {
        this.id = id;
    }

    public CryptoQuote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CryptoQuote that = (CryptoQuote) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
