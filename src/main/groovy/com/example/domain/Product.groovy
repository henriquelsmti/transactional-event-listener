package com.example.domain

import groovy.transform.CompileStatic
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
@CompileStatic
class Product {
	@Id
	Long id

	String name

	BigDecimal price
}
