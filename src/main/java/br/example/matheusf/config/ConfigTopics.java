package br.example.matheusf.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.example.matheusf.entity.Topico;

@Component
public class ConfigTopics {
	
	private List<Topico> topicos ;
	
	public ConfigTopics() {
		topicos = new ArrayList<>();
	}
	
	public List<Topico> getTopicos() {
		return topicos;
	}
	
}
