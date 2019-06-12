package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.security.RolesAllowed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	class Greeting {

		private final long id;
		private final String content;

		public Greeting(long id, String content) {
			this.id = id;
			this.content = content;
		}

		public long getId() {
			return id;
		}

		public String getContent() {
			return content;
		}
	}
	@RestController
	class DemoController {
		private final AtomicLong counter = new AtomicLong();
		
		@RolesAllowed({"USER", "ADMIN"}) 
		@RequestMapping("/greeting1")
		public Greeting greeting1(@RequestParam(value = "name", defaultValue = "World") String name) {
			return new Greeting(counter.incrementAndGet(), name);
		}

		@RolesAllowed({"USER", "ADMIN"}) 
		@RequestMapping("/greeting2")
		public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
			return new Greeting(counter.incrementAndGet(), name);
		}

		@RolesAllowed({"ADMIN"}) 
		@RequestMapping("/greeting3")
		public Greeting greeting3(@RequestParam(value = "name", defaultValue = "World") String name) {
			return new Greeting(counter.incrementAndGet(), name);
		}
	}
}
