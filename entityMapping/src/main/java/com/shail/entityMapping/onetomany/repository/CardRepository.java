package com.shail.entityMapping.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shail.entityMapping.onetomany.entity.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
