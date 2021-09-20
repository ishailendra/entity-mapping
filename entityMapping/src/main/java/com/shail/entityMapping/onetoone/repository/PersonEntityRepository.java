package com.shail.entityMapping.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shail.entityMapping.onetoone.entity.PersonEntity;

public interface PersonEntityRepository extends JpaRepository<PersonEntity, Integer>{

}
