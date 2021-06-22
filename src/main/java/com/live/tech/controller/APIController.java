package com.live.tech.controller;

import com.live.tech.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@RestController
public class APIController {

    ArrayList<Product> productsArrayList = new ArrayList<>(asList(new Product("1001", "SampleProductOne", "sample  product"),
            new Product("1002", "SampleProductTwo", "sample  product"),
            new Product("1003", "SampleProductThree", "sample  product")));

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productsArrayList;
    }

    @GetMapping("/findProduct/{id}")
    public Product findProduct(@PathVariable(value = "id") String productId) {
        Optional<Product> optionalProduct = productsArrayList.stream().filter(product -> product.getProductId().equals(productId)).findFirst();
        return optionalProduct.orElse(null);
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        productsArrayList.add(product);
        return "Product with productId: " + product.getProductId() + " added successfully";
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") String productId) {
        boolean productRemover = productsArrayList.removeIf(product -> product.getProductId().equals(productId));
        if (productRemover)
            return "Successfully removed product with productId " + productId;
        else return "Removal Failed";
    }

}
