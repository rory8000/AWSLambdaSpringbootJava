package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class Products {
  private List<Product> products;

  public Products() {
  }

  public Products(List<Product> products) {
    this.products = products;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
