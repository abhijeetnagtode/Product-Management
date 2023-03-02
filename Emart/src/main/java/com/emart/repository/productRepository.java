package com.emart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.model.Product;

public interface productRepository extends JpaRepository<Product, Integer> {

}
