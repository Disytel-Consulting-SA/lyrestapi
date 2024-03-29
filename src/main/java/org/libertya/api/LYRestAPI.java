package org.libertya.api;

import lombok.RequiredArgsConstructor;
import org.libertya.api.service.StartupLYService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
public class LYRestAPI {

	final StartupLYService service;

	public static void main(String[] args) {
		SpringApplication.run(LYRestAPI.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws Exception {
		service.init();
	}

}
