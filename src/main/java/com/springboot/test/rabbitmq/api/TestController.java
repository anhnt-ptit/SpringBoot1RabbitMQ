package com.springboot.test.rabbitmq.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.test.rabbitmq.dto.TestDto;
import com.springboot.test.rabbitmq.send.Sender;

@RestController
@RequestMapping("/test")
public class TestController {

	private static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	Sender sender;

	@RequestMapping(value = "/status", method = { RequestMethod.GET })
	public String status() {

		logger.info("Starting call to status service");

		logger.info("Ending call to status service");
		return "Running";
	}

	@RequestMapping(value = "/send", method = { RequestMethod.GET })
	public String send() {

		logger.info("Starting call to send service");

		TestDto testDto = TestDto.builder().name("anhnt").age(23).build();

		sender.send(testDto);

		logger.info("Ending call to send service");
		return "Running";
	}

}
