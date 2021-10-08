package com.edinfosuporte.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edinfosuporte.payroll.entities.Payment;
import com.edinfosuporte.payroll.entities.Worker;

@Service
public class PaymentService {
	
	private static final String URL_PATH = "/workers/{id}";
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(Long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerHost 
													+ URL_PATH, 
													Worker.class,
													uriVariables);
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
	}
	
	
}
