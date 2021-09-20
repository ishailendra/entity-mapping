package com.shail.entityMapping.manytomany.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "service")
@Getter 
@Setter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {

	@Id
	@Column(name = "service_id")
	private Integer serviceId;
	
	@Column(name = "service_name")
	private String serviceName;
	
	@ManyToMany(mappedBy = "merchantService", fetch = FetchType.EAGER)
	private List<MerchantEntity> merchants;
	
}
