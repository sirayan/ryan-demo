package com.product.productmanagement.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        log.info("Products displayed");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id){
        log.info("Product Displayed");
        return productService.getProduct(id);
    }

    @PostMapping
    public Product addNewProduct(@RequestBody  Product product){
        log.info("Product added");
        System.out.println(product);
        System.out.println(product.getProductName());
        return productService.addProduct(product.getProductName());
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer id){
        log.info("Product wiith id:"+id+" successfully updated.");
        return productService.updateProduct(id, product.getProductName());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        log.info("Deleted");
        productService.deleteProduct(id);
    }
}
