package com.edinfosuporte.payroll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edinfosuporte.payroll.resources.PaymentResources;

@SpringBootTest
class HrPayrollApplicationTests {

	@Autowired
	private PaymentResources resource;
	
	@Test
	public void getPaymentForWorkerAndShowThePayment() {
		Long id = 3L;
		Integer days = 10; 
		Assertions.assertThat(resource.getPaymentforWork(id, days).getBody().getName()).isNotNull();
	}

}
