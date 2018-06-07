package com.codingmackem.serviceb;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
public class ServiceBApplication {

	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}
	
	@GetMapping("/")
	@ResponseBody
	public String getTime() {
		return "The current time is " + new Date().toString()
				+ "(answered by service running on " + port + ")";
	}
}
