package com.shail.entityMapping.onetoone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter 
@Setter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer personId;
	
	@Column(name = "person_name")
	private String personName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_number", unique = true)
	private PassportEntity passport;
	
	
}
