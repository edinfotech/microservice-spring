package com.edinfosuporte.payroll.services;

import org.springframework.stereotype.Service;

import com.edinfosuporte.payroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("Miguel",200.00,days);
	}
}
