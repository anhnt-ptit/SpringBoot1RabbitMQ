package com.springboot.test.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	/*@Autowired
    ConnectionFactory connectionFactory;*/

    @Value("${test1.queue.name}")
    private String test1QueueName;
    
    @Value("${test1.exchange.name}")
    private String test1ExchangeName;
    
    @Value("${test1.routing.key}")
    private String test1KeyName;
    
    /*@Bean("test1Queue")
    public Queue test1Queue() {
        return new Queue(test1QueueName);
    }
    
	@Bean
	public TopicExchange test1Exchange() {
		return new TopicExchange(test1ExchangeName);
	}

	@Bean
	public Binding topicBinding() {
		return BindingBuilder.bind(test1Queue()).to(test1Exchange()).with(test1KeyName);
	}*/

    /*@Bean
    public SimpleRabbitListenerContainerFactory myRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter());
        return factory;
    }

    private MessageConverter messageConverter() {
        MessageConverter messageConverter = new Jackson2JsonMessageConverter();
        return messageConverter;
    }*/
	
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
