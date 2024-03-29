package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.security.RolesAllowed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	class DemoController {
		private final AtomicLong counter = new AtomicLong();

		@RolesAllowed({ "ROLE_USER" })
		@RequestMapping("/greeting1")
		public Greeting greeting1(@RequestParam(value = "name", defaultValue = "World") @NonNull String name) {
			return new Greeting(counter.incrementAndGet(), name);
		}

		@RolesAllowed({ "ROLE_USER" })
		@RequestMapping("/greeting2")
		public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") @NonNull String name) {
			return new Greeting(counter.incrementAndGet(), name);
		}

		@RolesAllowed({ "ROLE_USER" }) // 只有admin才能访问
		@RequestMapping("/greeting3")
		public Greeting greeting3(@RequestParam(value = "name", defaultValue = "World") @NonNull String name) {
			return new Greeting(counter.incrementAndGet(), name);
		}
	}
}
