package com.springboot.test.rabbitmq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.test.rabbitmq.dto.TestDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Sender {
	
//	@Autowired
//	private AmqpTemplate amqpTemplate;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${test1.exchange.name}")
    private String test1ExchangeName;
    
    @Value("${test1.routing.key}")
    private String test1KeyName;
	
	public void send(Object data) {
		log.info("Starting send message to queue message = {}", data);
		rabbitTemplate.convertAndSend(test1ExchangeName, test1KeyName, data);
		log.info("Ending send message to queue message = {}", data);
	}

}
