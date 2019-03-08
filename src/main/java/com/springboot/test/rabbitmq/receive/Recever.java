package com.springboot.test.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.test.rabbitmq.dto.TestDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Recever {

	@Value("${test1.queue.name}")
	private String test1QueueName;

	@RabbitListener(queues = "${test1.queue.name}")
	public void receiveTopic(TestDto data) {

		log.info("Received data = {}", data);

	}

}
