package br.example.matheusf.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.example.matheusf.producer.MessageSender;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private MessageSender sender;

    @GetMapping(value = "/read")
    public String send(@RequestParam("topic") String order,@RequestParam("routing") String routing,
    		@RequestParam("msg") String msg) {
        sender.send(order, routing, msg);
        return "Mensagem enviada";
    }

}