package com.edinfosuporte.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edinfosuporte.hrworker.entities.Worker;
import com.edinfosuporte.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger  logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment  env;
	
	@Autowired
	private WorkerRepository repository;
	
	
	@GetMapping(value = "/config")
	public ResponseEntity<Void> getConfigs(){
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAllWorkers(){
		 List<Worker> list = repository.findAll();
		 
		 if(list == null) {
			 return ResponseEntity.notFound().build();
		 }
		 
		 return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findWorkerById(@PathVariable Long id){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		 Worker worker = repository.findById(id).get();
		 
		 return ResponseEntity.ok(worker);
	}
}
