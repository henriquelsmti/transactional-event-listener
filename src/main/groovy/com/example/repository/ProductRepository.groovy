package com.example.repository

import com.example.domain.Product
import groovy.transform.CompileStatic
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import jakarta.transaction.Transactional

@Repository
@Transactional
@CompileStatic
interface ProductRepository extends JpaRepository<Product, Long> {
}
