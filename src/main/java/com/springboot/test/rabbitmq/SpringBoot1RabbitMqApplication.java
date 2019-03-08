package com.springboot.test.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.springboot.test.rabbitmq" })
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBoot1RabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1RabbitMqApplication.class, args);
	}

}
