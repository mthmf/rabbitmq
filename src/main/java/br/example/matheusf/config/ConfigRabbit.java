package br.example.matheusf.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.example.matheusf.entity.Topico;

@Configuration
public class ConfigRabbit {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ConfigTopics configTopics;

	@Bean(name="admin")
	public AmqpAdmin getRabbitAdmin() {
		adcTopicos();
		
		AmqpAdmin admin = new RabbitAdmin(this.rabbitTemplate.getConnectionFactory());
		configTopics.getTopicos().forEach(topic ->{
			admin.declareExchange(topic.getTopico());
			admin.declareQueue(topic.getFila());
			admin.declareBinding(BindingBuilder.bind(topic.getFila()).to(topic.getTopico()).with(topic.getRoutingKey()));
		});
		
		return admin;
	}
		
	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}
	
	
	public void adcTopicos() {
		for (int i = 1; i < 4; i++) {
			Topico topico = new Topico();
			topico.setTopico(new TopicExchange("TOPICO"+i));
			topico.setRoutingKey("rota.nome"+i+".*");
			topico.setFila(new Queue("fila.nome."+i));
			configTopics.getTopicos().add(topico);
		}
	}
	
}
