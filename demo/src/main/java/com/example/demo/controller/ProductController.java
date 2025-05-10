package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductJdbcRepository;


@RestController
@RequestMapping("/api")
public class ProductController {
 
 @Autowired
 ProductJdbcRepository productJdbcRepository;
 
 @PostMapping("/addproduct")
 public int addProduct(@RequestBody Product product) {
  return productJdbcRepository.addProduct(product);
 }
 
 @GetMapping("/viewproducts")
 public List<Product> getAllProducts(){
  return productJdbcRepository.getAllProducts();
 }
 
 @GetMapping("/product/{pr_id}")
 public Product getProductById(@PathVariable("pr_id") int pr_id) {
  return productJdbcRepository.getProductById(pr_id);
 }
 
 @PutMapping("/update_product")
 public int updateProduct(@RequestBody Product product) {
  return productJdbcRepository.updateProduct(product);
 }
 
 @DeleteMapping("/delete_product/{pr_id}")
 public int deleteProductById(@PathVariable("pr_id") int pr_id) {
  return productJdbcRepository.deleteProductById(pr_id);
 }


}