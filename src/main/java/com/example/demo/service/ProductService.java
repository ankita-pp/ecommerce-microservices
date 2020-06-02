package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(String id) {
		return productRepository.findById(id).orElse(null);
	}

	public String addProduct(Product product) {
		try {
			productRepository.save(product);
			return "Product is added successfully..!";
		} catch (Exception e) {
			log.error("Something went wrong..!", e);
			return "Something went wrong..!";
		}
	}

	public String deleteAllProducts() {
		try {
			productRepository.deleteAll();
			return "Products deleted successfully..!";
		} catch (Exception e) {
			log.error("Something went wrong..!",e);
			return "Try again..!";
		}
	}

	public String deleteProductById(String id) {
		try {
			productRepository.deleteById(id);
			return "Product deleted successfully..!";
		} catch (Exception e) {
			log.error("Something went wrong..!",e);
			return "Try again..!";
		}
	}
}
