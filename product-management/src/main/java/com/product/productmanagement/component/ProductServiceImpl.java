package com.product.productmanagement.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){this.productRepository=productRepository;}

    @Override
    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Integer id, String productName){
        Product product = productRepository.getOne(id);
        product.setProductName(productName);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
         productRepository.deleteById(id);
    }

    @Override
    public Product addProduct(String productName) {
        Product product = new Product();
        product.setProductName(productName);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
            return productRepository.findById(id);
    }
}
