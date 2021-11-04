package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.DiscoveryClient;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;
	
//	@Autowired
//	private DiscoveryClient eurekaClient;

	public void realizarCompra(CompraDTO compra) {
		
//		RestTemplate client = new RestTemplate();
//		ResponseEntity<InfoFornecedorDTO> exchange = 
//			client.exchange("http://localhost:8082/info" + compra.getEndereco().getEstado(),
//			HttpMethod.GET, null, InfoFornecedorDTO.class);
//		
//		System.out.println(exchange.getBody().getEndereco());

		ResponseEntity<InfoFornecedorDTO> exchange = 
			client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
			HttpMethod.GET, null, InfoFornecedorDTO.class);
		
//		eurekaClient.getInstancesById("fornecedor").stream()
//		.forEach(fornecedor -> {
//			System.out.println("localhost" + fornecedor.getPort());
//		});
		
		System.out.println(exchange.getBody().getEndereco());
		
	}

}
