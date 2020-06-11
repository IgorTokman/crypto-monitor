package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket.SimpleWsHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@EnableScheduling
@EnableReactiveMongoRepositories
@SpringBootApplication
public class CryptoMonitorApplication {
	private final String webSocketUri = "wss://api-pub.bitfinex.com/ws/2";

	@Bean
	public WebSocketConnectionManager wsConnectionManager() {
		WebSocketConnectionManager manager = new WebSocketConnectionManager(
				new StandardWebSocketClient(),
				new SimpleWsHandler(),
				this.webSocketUri);
		manager.setAutoStartup(true);

		return manager;
	}

	public static void main(String[] args) {
		SpringApplication.run(CryptoMonitorApplication.class, args);
	}
}
