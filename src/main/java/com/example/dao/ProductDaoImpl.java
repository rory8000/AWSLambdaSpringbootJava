package com.example.dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.model.Product;
import com.example.service.Products;
  
@Repository
public class ProductDaoImpl implements ProductDao {
  private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

  @Override
  public Optional<Product> getProduct(String id) {
    if (id.equals("1")) {
      Product product = new Product();
      product.setId("1");
      product.setName("Product 1");
      product.setPrice(new BigDecimal("10.00"));
      return Optional.of(product);
    } else {
      return Optional.empty();
    }
  }

  @Override
  public Products getAllProducts() {
    List<Product> productList = new ArrayList<>();

    Product product = new Product();
    product.setId("1");
    product.setName("Product 1");
    product.setPrice(new BigDecimal("10.00"));

    productList.add(product);

    product = new Product();
    product.setId("2");
    product.setName("Product 2");
    product.setPrice(new BigDecimal("20.00"));
    productList.add(product);

    logger.info("Scan returned: {} item(s)", productList.size());

    return new Products(productList);
  }

  @Override
  public void postProduct(Product product) {
    logger.info("Saving product returned: {} item(s)", ProductMapper.productToDynamoDb(product));
  }
}