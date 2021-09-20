package com.shail.entityMapping.onetomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "card")
@Getter 
@Setter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

	@Id
	@Column(name = "card_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cardId;
	
	@Column(name = "card_no")
	private String cardNo;
	
	@Column(name = "cardholder_name")
	private String cardholderName;
	
	@Column(name = "expiry_month")
	private String expiryMonth;
	
	@Column(name = "expiry_year")
	private String expiryYear;
	
}
