package com.shail.entityMapping.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shail.entityMapping.onetomany.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
