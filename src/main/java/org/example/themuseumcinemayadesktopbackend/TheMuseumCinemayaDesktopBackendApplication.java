package org.example.themuseumcinemayadesktopbackend;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Tag(name = "greeting-message")
public class TheMuseumCinemayaDesktopBackendApplication {

	@Value("${server.port}")
	private int serverPort;

	public static void main(String[] args) {
		SpringApplication.run(TheMuseumCinemayaDesktopBackendApplication.class, args);
	}

	@GetMapping
	public String greetingMessage(){
		return "The Museum Cinemaya Desktop Backend Application Running Well on Port " + serverPort;
	}
}
