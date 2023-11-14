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
class Service2 {

	private static final Logger LOG = LoggerFactory.getLogger(Service2)

	@Inject
	ProductRepository repository

	@Inject
	Service3 service3

	void todo(Product product) {
		LOG.info('Executing service2')
		product.price = 2
		repository.update(product)
		service3.todo(product)
		LOG.info('Executed service2')
	}
}
