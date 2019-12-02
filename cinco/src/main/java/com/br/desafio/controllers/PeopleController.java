package com.br.desafio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafio.models.People;
import com.br.desafio.services.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping
	public ResponseEntity<?> showPeople() {
		if(peopleService.amountOfPeople() > 0) {
			return ResponseEntity.ok(peopleService.findAllPeople());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> showPeopleByID(@PathVariable int id) {
		try {
			People people = peopleService.findPeopleById(id);
			return ResponseEntity.ok(people);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<People> addPeople(@Valid @RequestBody People people) {
		peopleService.savePeople(people);
		return ResponseEntity.status(HttpStatus.CREATED).body(people);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePeople(@PathVariable int id) {
		try {
			peopleService.deletePeople(id);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePeople(@PathVariable int id, @Valid @RequestBody People people) {
		peopleService.updatePeople(id, people);
		return ResponseEntity.ok().build();
	}

}
