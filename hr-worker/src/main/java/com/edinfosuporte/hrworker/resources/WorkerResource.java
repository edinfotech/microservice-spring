package com.edinfosuporte.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edinfosuporte.hrworker.entities.Worker;
import com.edinfosuporte.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;
	
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
		 Worker worker = repository.findById(id).get();
		 
		 return ResponseEntity.ok(worker);
	}
}
