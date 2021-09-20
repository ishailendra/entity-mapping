package com.shail.entityMapping.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shail.entityMapping.manytomany.entity.MerchantEntity;

public interface MerchantRepository  extends JpaRepository<MerchantEntity, Integer> {

}
