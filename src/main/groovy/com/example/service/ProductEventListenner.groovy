package com.example.service

import com.example.events.ProductEvent
import groovy.transform.CompileStatic
import io.micronaut.transaction.TransactionOperations
import io.micronaut.transaction.TransactionStatus
import io.micronaut.transaction.annotation.TransactionalEventListener
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.hibernate.Session
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
@CompileStatic
class ProductEventListenner {
	private static final Logger LOG = LoggerFactory.getLogger(ProductEventListenner)

	@Inject
	TransactionOperations<Session> transactionManager

	@TransactionalEventListener
	void on(ProductEvent event) {
		LOG.info('Execute TransactionalEventListener')
		Optional<? extends TransactionStatus<?>> optionalTransactionStatus = transactionManager.findTransactionStatus()
		optionalTransactionStatus.ifPresent { TransactionStatus status ->
			if (!status.completed) {
				throw new IllegalStateException('Transaction not completed')
			}
		}
	}
}
