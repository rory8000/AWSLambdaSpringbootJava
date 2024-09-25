package com.example.dao;

import java.util.Optional;

import com.example.model.Product;
import com.example.service.Products;

public interface ProductDao {

  Optional<Product> getProduct(String id);

  Products getAllProducts();

  void postProduct(Product product);
}