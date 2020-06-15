package ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.integration.bitfinex.Contract;

@Configuration
public class WSConfiguration {

	@Autowired
	SimpleWsHandler wsHandler;

	@Bean
	public WebSocketConnectionManager wsConnectionManager() {
		WebSocketConnectionManager manager = new WebSocketConnectionManager(
				new StandardWebSocketClient(),
				wsHandler,
				Contract.endpoint);
		manager.setAutoStartup(true);

		return manager;
	}

}