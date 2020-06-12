package ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.CryptoQuote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.helper.TickerConverter;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.CryptoQuoteRepository;

@Configuration
public class WSConfiguration {

	@Autowired
	SimpleWsHandler wsHandler;

	private final String webSocketUri = "wss://api-pub.bitfinex.com/ws/2";

	@Bean
	public WebSocketConnectionManager wsConnectionManager() {
		WebSocketConnectionManager manager = new WebSocketConnectionManager(
				new StandardWebSocketClient(),
				wsHandler,
				this.webSocketUri);
		manager.setAutoStartup(true);

		return manager;
	}

}