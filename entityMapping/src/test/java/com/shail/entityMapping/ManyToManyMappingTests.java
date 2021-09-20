package com.shail.entityMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shail.entityMapping.manytomany.entity.MerchantEntity;
import com.shail.entityMapping.manytomany.entity.ServiceEntity;
import com.shail.entityMapping.manytomany.repository.MerchantRepository;
import com.shail.entityMapping.manytomany.repository.ServiceRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManyToManyMappingTests {

	@Autowired
	private MerchantRepository merchantRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;

	private ServiceEntity serviceEntity1 = null;
	private ServiceEntity serviceEntity2 = null;
	private ServiceEntity serviceEntity3 = null;
	private MerchantEntity merchantEntity1 = null;
	private MerchantEntity merchantEntity2 = null;

	@BeforeAll
    public void setup() {

		serviceEntity1 = ServiceEntity.builder()
                                        .serviceId(1)
                                        .serviceName("Plumbing")
                                        .build();
        serviceEntity2 = ServiceEntity.builder()
                                        .serviceId(2)
                                        .serviceName("Home Renovation")
                                        .build();
        
        serviceEntity3 = ServiceEntity.builder()
                                        .serviceId(3)
                                        .serviceName("Carpenting")
                                        .build();

        
        List<ServiceEntity> serviceList1 = new ArrayList<>();
        serviceList1.add(serviceEntity1);
        serviceList1.add(serviceEntity2);
        
        List<ServiceEntity> serviceList2 = new ArrayList<>();
        serviceList2.add(serviceEntity1);
        serviceList2.add(serviceEntity3);
        
        
        merchantEntity1 = MerchantEntity.builder()
                                            .merchantId(1)
                                            .merchantName("John's Builder")
                                            .merchantService(serviceList1)
                                            .build();
        
        merchantEntity2 = MerchantEntity.builder()
                                            .merchantId(2)
                                            .merchantName("Jack Repairs")
                                            .merchantService(serviceList2)
                                            .build();
        
        merchantEntity1 = merchantRepository.save(merchantEntity1);
        
        merchantEntity2 = merchantRepository.save(merchantEntity2);
        
        List<MerchantEntity> me1 = new ArrayList<>();
		me1.add(merchantEntity1);
		me1.add(merchantEntity2);
		
		List<MerchantEntity> me2 = new ArrayList<>();
		me2.add(merchantEntity1);
		
		List<MerchantEntity> me3 = new ArrayList<>();
		me3.add(merchantEntity2);
		
		serviceEntity1.setMerchants(me1);
		serviceEntity2.setMerchants(me2);
		serviceEntity3.setMerchants(me3);
		
		serviceRepository.save(serviceEntity1);
		serviceRepository.save(serviceEntity2);
    }

	
	
	@Test
	public void testManyToMany() {

		MerchantEntity merchant1 = merchantRepository.findById(1).orElse(null);

		assertNotNull(merchant1.getMerchantService());
		assertEquals("Plumbing", merchant1.getMerchantService().get(0).getServiceName());
		assertEquals("Home Renovation", merchant1.getMerchantService().get(1).getServiceName());
		
		MerchantEntity merchant2 = merchantRepository.findById(2).orElse(null);

		assertNotNull(merchant2.getMerchantService());
		assertEquals("Plumbing", merchant2.getMerchantService().get(0).getServiceName());
		assertEquals("Carpenting", merchant2.getMerchantService().get(1).getServiceName());
		
		
		ServiceEntity serviceEntity1 = serviceRepository.findByServiceName("Plumbing");
		assertNotNull(serviceEntity1.getMerchants());
		assertEquals("John's Builder", serviceEntity1.getMerchants().get(0).getMerchantName());
		assertEquals("Jack Repairs", serviceEntity1.getMerchants().get(1).getMerchantName());
		
		ServiceEntity serviceEntity2 = serviceRepository.findByServiceName("Carpenting");
		assertNotNull(serviceEntity2.getMerchants());
		assertEquals("Jack Repairs", serviceEntity2.getMerchants().get(0).getMerchantName());
	}
}
