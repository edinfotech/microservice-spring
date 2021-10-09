package com.edinfosuporte.payroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edinfosuporte.payroll.entities.Payment;
import com.edinfosuporte.payroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentResources {

	@Autowired
	private PaymentService paymentService;
	
	@HystrixCommand(fallbackMethod = "getPaymentforWorkAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPaymentforWork(@PathVariable Long workerId, @PathVariable Integer days){
		return ResponseEntity.ok(this.paymentService.getPayment(workerId, days));
		
	}
	
	public ResponseEntity<Payment> getPaymentforWorkAlternative(Long workerId, Integer days){
		Payment payment = new Payment("Miguel", 400.00, days);
		return ResponseEntity.ok(payment);
	}
}
