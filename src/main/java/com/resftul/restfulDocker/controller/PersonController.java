package com.resftul.restfulDocker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resftul.restfulDocker.exception.ResourceNotFoundException;
import com.resftul.restfulDocker.model.Person;
import com.resftul.restfulDocker.respository.PersonRepository;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	// Create get all persons
	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	// Create person
	@PostMapping("/persons")
	public Person CreatePerson(@Validated @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	// Get person by id
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") long personId)
		throws ResourceNotFoundException {
			Person person = personRepository.findById(personId)
					.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
			return ResponseEntity.ok().body(person);
	}
	
	
	// Update person
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
			@Validated @RequestBody Person personDetails) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

		person.setEmail(personDetails.getEmail());
		person.setFullName(personDetails.getFullName());
		final Person updatedPerson = personRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
	}
	
	// Delete person
	@DeleteMapping("/persons/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
