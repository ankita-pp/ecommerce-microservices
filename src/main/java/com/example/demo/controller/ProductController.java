package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.common.ConstantAttributes.*;

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
