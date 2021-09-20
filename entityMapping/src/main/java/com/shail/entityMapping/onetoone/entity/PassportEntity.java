package com.shail.entityMapping.onetoone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passport")
@Getter 
@Setter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassportEntity {

	@Id
	@Column(name = "passport_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer passportId;
	
	@Column(name = "passport_number")
	private String passportNumber;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "passport_type")
	private String passportType;
	
	@OneToOne(mappedBy = "passport")
	private PersonEntity person;
}
