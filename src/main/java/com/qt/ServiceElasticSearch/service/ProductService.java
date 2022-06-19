package com.qt.ServiceElasticSearch.service;

import com.qt.ServiceElasticSearch.model.ProductEntity;
import com.qt.ServiceElasticSearch.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> getAllProduct() throws Exception {
        try {
            Iterable<ProductEntity> iterableProducts = productRepository.findAll();

            List<ProductEntity> listProducts = null;
            if (iterableProducts != null) {
                listProducts = StreamSupport.stream(iterableProducts.spliterator(), false)
                        .collect(Collectors.toList());
            }

            return listProducts;
        } catch (Exception e) {
//            logger.info("The connection with DB {} ",e);
            throw new Exception(e.getMessage());
        }

    }
}
