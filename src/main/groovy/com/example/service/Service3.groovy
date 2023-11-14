package com.example.service

import com.example.domain.Product
import com.example.events.ProductEvent
import com.example.repository.ProductRepository
import groovy.transform.CompileStatic
import io.micronaut.context.event.ApplicationEventPublisher
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
@CompileStatic
@Transactional
class Service3 {

	private static final Logger LOG = LoggerFactory.getLogger(Service3)

	@Inject
	ProductRepository repository

	@Inject
	ApplicationEventPublisher applicationEventPublisher

	void todo(Product product) {
		LOG.info('Executing service3')
		product.price = 3
		repository.update(product)
		applicationEventPublisher.publishEvent(new ProductEvent())
		LOG.info('Executed service3')
	}
}
