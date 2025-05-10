package com.example.demo.repository;

    
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductJdbcRepository {
 
 @Autowired
 JdbcTemplate jdbcTemplate;
 
 @Override
 public int addProduct(Product product) {
  String insertQuery = "insert into product(pr_name, pr_price) values (?,?)";
  return jdbcTemplate.update(insertQuery,product.getPrName(),product.getPrPrice());
 }
 @Override
 public List<Product> getAllProducts() {
  String selectAllQuery = "select pr_id, pr_name, pr_price, pr_status from product where pr_status = '0' ";
  List<Product> allproductsList = jdbcTemplate.query(selectAllQuery, new BeanPropertyRowMapper<Product>(Product.class));
  return allproductsList;
 }
 @Override
 public Product getProductById(int pr_id) {
  String selectByIdQuery = "select pr_id, pr_name, pr_price, pr_status from product where pr_id = ?";
  Product product = jdbcTemplate.queryForObject(selectByIdQuery, BeanPropertyRowMapper.newInstance(Product.class), pr_id);
  return product;
 }
 @Override
 public int updateProduct(Product product) {
  String updateQuery = "update product set  pr_name = ?, pr_price = ? where pr_id = ?";
  return jdbcTemplate.update(updateQuery,product.getPrName(),product.getPrPrice(), product.getPrId());
 }
 @Override
 public int deleteProductById(int pr_id) {
  String deleteByIdQuery = "update product set pr_status = '1' where pr_id = ?";
  return jdbcTemplate.update(deleteByIdQuery, pr_id);
 }
}

