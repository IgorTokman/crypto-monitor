package ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket;

import org.springframework.web.socket.*;

public class SimpleWsHandler implements WebSocketHandler {

	/**
	 * Called when WS connects to the server.
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		session.sendMessage(
				new BinaryMessage("{ \"event\": \"subscribe\",  \"channel\": \"ticker\",  \"symbol\": \"tBTCUSD\" }".getBytes()));
	}

	/**
	 * Main method to handle server messages.
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println(message.getPayload());
	}

	/**
	 * Error handling.
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
				
	}

	/**
	 * Called when WS is closed.
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}