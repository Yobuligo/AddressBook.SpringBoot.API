package com.yobuligo.AddressBook.Web.SpringBoot.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	IPersonRepository personRepository;

	@GetMapping("/persons")
	public Iterable<Person> findAllPersons() {
		return personRepository.findAll();
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		personRepository.save(person);
		return person;
	}

	@DeleteMapping("/persons/{id}")
	public Person deletePerson(@PathVariable Long id) {
		Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException());
		personRepository.delete(person);
		return person;
	}
}
