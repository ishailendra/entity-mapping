package com.shail.entityMapping.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shail.entityMapping.onetoone.entity.PassportEntity;

public interface PassportRepository extends JpaRepository<PassportEntity, Integer> {

	PassportEntity findByPassportNumber(String passportNumber);
}
