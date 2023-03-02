package com.emart.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.model.Product;
import com.emart.service.productService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private productService productService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAll() {
		List<Product> productlist = productService.getAll();
		return ResponseEntity.ok().body(productlist);
	}

	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product saveproduct = productService.saveProduct(product);
		return ResponseEntity.ok().body(saveproduct);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable("id") Integer id) {
		productService.deletById(id);
		Map<String, String>message=Map.of("messsage","product delete successfully");
		return ResponseEntity.ok().body(message);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		Product productId = productService.getProductById(id);
		return ResponseEntity.ok().body(productId);
	}

	@PostMapping("/{prodictId}")
	public ResponseEntity<Product> updteProduct(@RequestBody Product product,@PathVariable Integer prodictId) {
		Product Product1 = this.productService.updteProduct(product,prodictId);
		return ResponseEntity.ok().body(Product1);
	}
}
