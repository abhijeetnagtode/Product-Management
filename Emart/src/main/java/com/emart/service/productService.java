package com.emart.service;

import java.util.List;

import com.emart.model.Product;

public interface productService {

	// get product
	public List<Product> getAll();

	// save product
	public Product saveProduct(Product product);

	// delete
	void deletById(Integer id);

	// get by id
	Product getProductById(Integer id);

	// update
	Product updteProduct(Product product, Integer productId);


}
