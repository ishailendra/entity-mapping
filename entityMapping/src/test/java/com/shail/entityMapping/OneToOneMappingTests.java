package com.shail.entityMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shail.entityMapping.onetoone.entity.PassportEntity;
import com.shail.entityMapping.onetoone.entity.PersonEntity;
import com.shail.entityMapping.onetoone.repository.PassportRepository;
import com.shail.entityMapping.onetoone.repository.PersonEntityRepository;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OneToOneMappingTests {


	@Autowired
	private PersonEntityRepository personRepo;

	@Autowired
	private PassportRepository passportRepository;

	private PersonEntity person = null;
	private PassportEntity passport = null;
	private Integer personId;
	
	@BeforeAll
    public void setup() {
		passport = PassportEntity.builder()
				.passportNumber("A1234567")
				.country("India")
				.passportType("Diplomatic")
				.build();

		person =  PersonEntity.builder()
				.personName("John Doe")
				.passport(passport)
				.build();

		person = personRepo.save(person);
		personId = person.getPersonId();
    }

	@Test
	public void testOneToOne() {

		PersonEntity person  = personRepo.findById(personId).orElse(null);

		assertNotNull(person.getPassport());
		assertEquals("A1234567", person.getPassport().getPassportNumber());
		
		PassportEntity passport = passportRepository.findByPassportNumber("A1234567");
		
		assertNotNull(passport.getPerson());
		assertEquals("John Doe", passport.getPerson().getPersonName());

	}

}
