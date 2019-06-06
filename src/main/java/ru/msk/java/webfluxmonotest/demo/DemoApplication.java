package ru.msk.java.webfluxmonotest.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import ru.msk.java.webfluxmonotest.demo.processing.Response;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	final static String uri = "http://localhost:8080/test";
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	/*	RestTemplate restTemplate = new RestTemplate();
		Response response = restTemplate.getForObject(uri, Response.class);
		log.info(response.toString());*/
	}

}
