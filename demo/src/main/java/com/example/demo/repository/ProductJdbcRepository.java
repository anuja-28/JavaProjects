package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.Product;

public interface ProductJdbcRepository {
 int addProduct(Product product);
 List<Product> getAllProducts();
 Product getProductById(int pr_id);
 int updateProduct(Product product);
 int deleteProductById(int pr_id);
}