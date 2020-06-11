package ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket;

import org.springframework.web.socket.*;

public class SimpleWsHandler implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String request = "{ \"event\": \"subscribe\",  \"channel\": \"ticker\",  \"symbol\": \"tBTCUSD\" }";
		session.sendMessage(new BinaryMessage(request.getBytes()));
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println(message.getPayload());
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {}

	@Override
	public boolean supportsPartialMessages() { return false; }

}