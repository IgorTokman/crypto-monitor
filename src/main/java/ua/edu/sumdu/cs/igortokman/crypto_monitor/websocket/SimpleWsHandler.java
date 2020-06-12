package ua.edu.sumdu.cs.igortokman.crypto_monitor.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.domain.CryptoQuote;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.helper.TickerConverter;
import ua.edu.sumdu.cs.igortokman.crypto_monitor.repository.CryptoQuoteRepository;

import java.util.Arrays;

@Component
public class SimpleWsHandler implements WebSocketHandler {

	@Autowired
	private CryptoQuoteRepository cryptoQuoteRepository;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String request = "{ \"event\": \"subscribe\",  \"channel\": \"ticker\",  \"symbol\": \"tBTCUSD\" }";
		session.sendMessage(new BinaryMessage(request.getBytes()));
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		CryptoQuote quote = new TickerConverter().map(message.getPayload().toString());

		System.out.println(quote);
		System.out.println("<<<<");
		System.out.println(cryptoQuoteRepository);
		System.out.println(">>>>>");

		if (quote != null) {
			cryptoQuoteRepository.save(quote).subscribe();
			System.out.println(quote);
			System.out.println("=============");
		}
//		mapper.readValue(payload)
//		Double[] doubles = mapper.readValue(message.getPayload().toString(), Double[].class);
//		System.out.println("doubles");
//		System.out.println(Arrays.toString(doubles));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {}

	@Override
	public boolean supportsPartialMessages() { return false; }

}