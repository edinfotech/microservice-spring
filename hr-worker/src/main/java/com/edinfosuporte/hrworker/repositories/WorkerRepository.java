package com.edinfosuporte.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edinfosuporte.hrworker.entities.Worker;

public interface WorkerRepository  extends JpaRepository<Worker, Long>{

}
