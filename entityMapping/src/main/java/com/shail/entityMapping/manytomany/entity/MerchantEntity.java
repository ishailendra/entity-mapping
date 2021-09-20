package com.shail.entityMapping.manytomany.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "merchant")
@Getter 
@Setter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantEntity {

	@Id
	@Column(name = "merchant_id")
	private Integer merchantId;
	
	@Column(name = "merchant_name")
	private String merchantName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "merchant_service_mapping",
				joinColumns = @JoinColumn(name = "merchant_id", referencedColumnName = "merchant_id"),
				inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "service_id"))
	private  List<ServiceEntity> merchantService;
}
