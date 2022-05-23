package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;
	
	private Long nonExistingId;
	private long existingId;
	private long countTotalProducs;
	
	@BeforeEach
	void setUp() throws Exception {
		nonExistingId = 1000L;
		existingId = 1L;
		countTotalProducs = 25L;
	}
	
	@Test
	public void findByIdShouldReturnNotEmptyObjectWhenIdExist() {
		Optional<Product> optional = repository.findById(existingId);
	
		Assertions.assertTrue(optional.isPresent());
	}
	
	
	@Test
	public void findByIdShouldReturnEmptyObjectWhenIdDoesNotExist() {
		Optional<Product> optional = repository.findById(nonExistingId);
	
		Assertions.assertTrue(optional.isEmpty());
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
		
		Product product = Factory.createProduct();
		product.setId(null);
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProducs + 1, product.getId());
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIDExists() {
		
		repository.deleteById(existingId);
		
		Optional<Product> result = repository.findById(existingId);
		Assertions.assertFalse(result.isPresent());
		
	}
	
	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
				
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
		
	}
	
}
