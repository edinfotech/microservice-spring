package com.edinfosuporte.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edinfosuporte.payroll.entities.Payment;
import com.edinfosuporte.payroll.entities.Worker;
import com.edinfosuporte.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(Long workerId, int days) {
		
		Worker worker = workerFeignClient.findWorkerById(workerId).getBody();
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
	}
	
	
}
