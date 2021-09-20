package com.shail.entityMapping.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shail.entityMapping.manytomany.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer>{

	ServiceEntity findByServiceName(String string);

}
