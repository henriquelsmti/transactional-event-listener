package com.example.service

import com.example.domain.Product
import com.example.repository.ProductRepository
import groovy.transform.CompileStatic
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
@CompileStatic
@Transactional
class Service1 {

	private static final Logger LOG = LoggerFactory.getLogger(Service1)

	@Inject
	ProductRepository repository

	@Inject
	Service2 service2

	void todo(Product product) {
		LOG.info('Executing service1')
		product.price = 1
		repository.update(product)
		service2.todo(product)
		LOG.info('Executed service1')
	}
}
