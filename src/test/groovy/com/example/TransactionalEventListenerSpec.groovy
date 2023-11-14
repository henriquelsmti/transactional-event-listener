package com.example

import com.example.domain.Product
import com.example.repository.ProductRepository
import com.example.service.Service1
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification
import jakarta.inject.Inject

@MicronautTest(transactional = false)
class TransactionalEventListenerSpec extends Specification {

	private static final Logger LOG = LoggerFactory.getLogger(TransactionalEventListenerSpec)

	@Inject
	ProductRepository productRepository

	@Inject
	Service1 service1

	void 'test event'() {
		setup:
		Product product = new Product().tap {
			id = 1
			name = 'product'
			price = 0
		}
		productRepository.save(product)
		when:
		LOG.info('Before service1')
		service1.todo(product)
		LOG.info('after service1')
		then:
		noExceptionThrown()
	}

}
