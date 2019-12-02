package com.br.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.desafio.models.People;
import com.br.desafio.repositories.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	// Method for amount of people
	public Long amountOfPeople() {
		return peopleRepository.count();
	}
	
	// Method to find all people
	public Iterable<People> findAllPeople() {
		return peopleRepository.findAll();
	}
	
	// Method to find an specific people by id
	public People findPeopleById(int id) {
		return peopleRepository.findById(id).get();
	}
	
	// Method to add people
	public void savePeople(People people) {
		peopleRepository.save(people);
	}
	
	// Method to delete an specific people
	public void deletePeople(int id) {
		peopleRepository.deleteById(id);
	}
	
	// Method to update a people
	public void updatePeople(int id, People people) {
		Optional<People> optionalPeople = peopleRepository.findById(id);
		if(optionalPeople.isPresent()) {
			people.setId(id);
			peopleRepository.save(people);
		}
	}

}
