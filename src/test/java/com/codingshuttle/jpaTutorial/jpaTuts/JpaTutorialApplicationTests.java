package com.codingshuttle.jpaTutorial.jpaTuts;

import com.codingshuttle.jpaTutorial.jpaTuts.entites.ProductEntity;
import com.codingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepositories productRepositories;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(23.45))
				.quantity(4)
				.build();

		ProductEntity savedProductEntity = productRepositories.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities = productRepositories.findByCreatedAtAfter(
//				LocalDateTime.of(2026,1,1,0,0,0));
//		List<ProductEntity> entities = productRepositories.
//				findByQuantityGreaterThanOrPriceLessThan(4, BigDecimal.valueOf(23.45));
//		List<ProductEntity> entities = productRepositories.findByTitleLike("%Choco%");
		List<ProductEntity> entities = productRepositories.findByTitleContainingIgnoreCase("CHOco");


		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> entities = productRepositories.
				findByTitleAndPrice("Pepsi", BigDecimal.valueOf(14.4));
		entities.ifPresent(System.out::println);
	}



}
