package br.example.matheusf.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	 
    @RabbitListener(queues="fila.nome.1")
    public void receive(@Payload String msg) {
       System.out.println("Mensagem: " + msg);
    }
}
