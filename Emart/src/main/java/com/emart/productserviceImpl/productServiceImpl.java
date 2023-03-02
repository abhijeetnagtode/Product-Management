package com.emart.productserviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.model.Product;
import com.emart.repository.productRepository;
import com.emart.service.productService;

@Service
public class productServiceImpl implements productService {

	@Autowired // repo
	private productRepository productRepository;

	public productRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(productRepository productRepository) {
		this.productRepository = productRepository;
	}

	// save
	@Override
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}

	// delete
	@Override
	public void deletById(Integer id) {
		this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
		this.productRepository.deleteById(id);

	}

	@Override
	public Product getProductById(Integer id) {
		Product product1 = this.productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("product not found"));
		return product1;
	}

	@Override
	public List<Product> getAll() {
		List<Product> all = this.productRepository.findAll();
		return all;
	}

	@Override
	public Product updteProduct(Product product, Integer productId) {
		Product product1 = this.productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("prpduct not found"));
		product1.setPrice(product.getPrice());
		product1.setDiscription(product.getDiscription());
		product1.setName(product.getName());
		Product save = this.productRepository.save(product1);
		return save;
	}

}
