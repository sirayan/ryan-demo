package com.product.productmanagement.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService{

    Collection<Product> getAllProducts();
    Optional<Product> getProduct(Integer id);
    Product addProduct(String productName);
    Product updateProduct(Integer id, String productName);
    void deleteProduct(Integer id);

}
