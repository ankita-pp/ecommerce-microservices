package com.example.demo.controller;

import static com.example.demo.common.ConstantAttributes.ADD_PRODUCT;
import static com.example.demo.common.ConstantAttributes.DELETE_ALL_PRODUCTS;
import static com.example.demo.common.ConstantAttributes.DELETE_PRODUCT_BY_ID;
import static com.example.demo.common.ConstantAttributes.GET_ALL_PRODUCTS;
import static com.example.demo.common.ConstantAttributes.GET_PRODUCT_BY_ID;
import static com.example.demo.common.ConstantAttributes.UPDATE_PRODUCT;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping(GET_ALL_PRODUCTS)
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(GET_PRODUCT_BY_ID)
	public Product findProductById(@PathVariable String id) {
		return productService.getProductById(id);
	}

	@PostMapping(ADD_PRODUCT)
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping(UPDATE_PRODUCT)
	public String updateProduct(@RequestBody Product product) {
		//UPDATE PRODUCT
		return productService.addProduct(product);
	}

	@DeleteMapping(DELETE_ALL_PRODUCTS)
	public String deleteAll() {
		return productService.deleteAllProducts();
	}

	@DeleteMapping(DELETE_PRODUCT_BY_ID)
	public String deleteProductById(@PathVariable String id) {
		return productService.deleteProductById(id);
	}


}
