package br.example.matheusf.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.example.matheusf.config.ConfigRabbit;

@Component
public class MessageSender {

	@Autowired
	private ConfigRabbit config;
	
	public void send(String topic, String routing, String msg) {
		config.getRabbitTemplate().convertAndSend(topic, routing, msg );
	}
	
	
}
