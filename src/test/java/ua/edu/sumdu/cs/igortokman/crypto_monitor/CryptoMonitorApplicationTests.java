package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient(timeout = "36000")
class CryptoMonitorApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void findAllQuotes() {
		webClient.get().uri("/quotes").accept(MediaType.APPLICATION_STREAM_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(CryptoQuote.class).hasSize(10);

	}
}
