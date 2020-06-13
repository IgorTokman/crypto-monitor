package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CryptoMonitorApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@BeforeEach
	public void setUp() {
		webClient = webClient
				.mutate()
				.responseTimeout(Duration.ofSeconds(36000))
				.build();
	}
//
//	@Test
//	void findLastQuotes() {
//		webClient.get().uri("/trading-events").accept(MediaType.APPLICATION_STREAM_JSON)
//				.exchange()
//				.expectStatus().isOk()
//				.expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
//				.expectBodyList(Quote.class);
//
//	}
}
