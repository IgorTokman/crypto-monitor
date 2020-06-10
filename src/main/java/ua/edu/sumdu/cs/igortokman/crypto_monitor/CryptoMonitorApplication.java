package ua.edu.sumdu.cs.igortokman.crypto_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CryptoMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoMonitorApplication.class, args);
	}

}
