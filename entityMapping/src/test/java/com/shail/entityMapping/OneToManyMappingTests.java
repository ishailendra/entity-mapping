package com.shail.entityMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shail.entityMapping.onetomany.entity.Card;
import com.shail.entityMapping.onetomany.entity.Person;
import com.shail.entityMapping.onetomany.repository.PersonRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OneToManyMappingTests {


	@Autowired
	private PersonRepository personRepo;

	private Person person = null;
	private Card card1 = null;
	private Card card2 = null;

	private Integer personId;
	
	@BeforeAll
    public void setup() {

		card1 = Card.builder()
				.cardholderName("John Doe")
				.cardNo("4578963214502354")
				.expiryMonth("12")
				.expiryYear("2022")
				.build();

		card2 = Card.builder()
				.cardholderName("John Doe")
				.cardNo("4111111111111111")
				.expiryMonth("02")
				.expiryYear("2025")
				.build();

		List<Card> cards = new ArrayList<>();
		cards.add(card1);
		cards.add(card2);
		
		person =  Person.builder()
				.personName("John Doe")
				.cards(cards)
				.build();

		person = personRepo.save(person);
		personId = person.getPersonId();
    }

	
	@Test
	public void testOneToMany() {

		Person person  = personRepo.findById(personId).orElse(null);

		assertNotNull(person.getCards());
		assertEquals("4578963214502354", person.getCards().get(0).getCardNo());
		assertEquals("4111111111111111", person.getCards().get(1).getCardNo());

	}

}

