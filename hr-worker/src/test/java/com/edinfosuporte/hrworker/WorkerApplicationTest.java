package com.edinfosuporte.hrworker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.edinfosuporte.hrworker.entities.Worker;
import com.edinfosuporte.hrworker.repositories.WorkerRepository;


@DataJpaTest
public class WorkerApplicationTest {


	@Autowired
	private WorkerRepository repository;

	@Test
	public void geAlltWorkersAndFindAll() {
		List<Worker> list = this.repository.findAll();
		assertFalse(list.isEmpty());
	}

	
	@Test
	public void geWorkerByIdAndFindHim() {
		Long id = 3L;
		assertThat(this.repository.findById(id)).isNotEmpty();
	}
	

}
