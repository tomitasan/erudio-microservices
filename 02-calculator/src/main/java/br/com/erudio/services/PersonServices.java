package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

/*
 * @Service - faz com que o Spring cuide da injeção de dependências para esta classe
 * não precisar usar um new PersonService() - utilizaria apenas o Autowired
**/

@Service
public class PersonServices {
	
//	O atomicLong simula um id do banco de dados - gera um id novo
	private final AtomicLong counter = new AtomicLong();
		
	public Person findById( String id) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Antonio");
		person.setLastName("Tomita");
		person.setAddress("Av. Paulista");
		person.setGender("Male");
				
		return person ;
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}	
	
	public void delete(String id) {
		
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			Person person = mockPerson(i);
			persons.add(person);			
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Last name" + i);
		person.setAddress("Some address in Brasil" + i);
		person.setGender("Male");
		return person;
	}
}
