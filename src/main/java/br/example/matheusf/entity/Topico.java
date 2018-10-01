package br.example.matheusf.entity;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.stereotype.Component;

@Component
public class Topico {
	
	private TopicExchange topico ;
	private Queue fila;
	private String routingKey;
	

	public TopicExchange getTopico() {
		return topico;
	}

	public void setTopico(TopicExchange topico) {
		this.topico = topico;
	}

	public Queue getFila() {
		return fila;
	}

	public void setFila(Queue fila) {
		this.fila = fila;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	
}
