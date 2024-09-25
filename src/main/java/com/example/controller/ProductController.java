package com.example.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.dao.ProductDaoImpl;
import com.example.model.Product;
import com.example.service.Products;

@RestController
@EnableWebMvc
public class ProductController {

	@Autowired
	private ProductDaoImpl productDao;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(path = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Products getAllProduct() {
		logger.info("entered getAllProduct method");
		Products optionalProduct = productDao.getAllProducts();
		logger.info(" products : " + optionalProduct);
		return optionalProduct;
	}

	@RequestMapping(path = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Product> getProductById(@PathVariable("id") String id) {
		logger.info("entered getProductById method with id " + id);
		Optional<Product> optionalProduct = productDao.getProduct(id);
		if (optionalProduct.isPresent())
			logger.info(" product : " + optionalProduct.get());
		else
			logger.info(" product not found ");
		return optionalProduct;
	}

	@RequestMapping(path = "/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createProduct(@RequestBody Product product) {
		logger.info("entered createProduct method with id " + product.getId());
		productDao.postProduct(product);
	}
}