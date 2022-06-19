package com.qt.ServiceElasticSearch.controller;

import com.qt.ServiceElasticSearch.model.ProductEntity;
import com.qt.ServiceElasticSearch.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class MainController {

    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/v1/products")
    public ResponseEntity<?> getAllEmployee() throws Exception {
        List<ProductEntity> listProduct = productService.getAllProduct();
        log.debug("object {}", listProduct.toArray());
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }
}
