package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.CryptoQuoteRepository;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket.SimpleWsHandler;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class CryptoMonitorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CryptoMonitorApplication.class, args);
	}
}
