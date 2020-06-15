package ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.Quote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.integration.bitfinex.Contract;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.integration.bitfinex.TickerConverter;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.service.TradingService;

@Service
public class SimpleWsHandler implements WebSocketHandler {

	@Autowired
	private TradingService tradingService;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		session.sendMessage(new BinaryMessage(Contract.confirmationRequest.getBytes()));
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		Quote quote = new TickerConverter().map(message.getPayload().toString());

		if (quote != null) {
			tradingService.save(quote);
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {}

	@Override
	public boolean supportsPartialMessages() { return false; }

}