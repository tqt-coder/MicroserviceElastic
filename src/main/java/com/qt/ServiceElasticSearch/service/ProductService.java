package com.qt.ServiceElasticSearch.service;

import com.qt.ServiceElasticSearch.model.ProductEntity;
import com.qt.ServiceElasticSearch.model.ProductModel;
import com.qt.ServiceElasticSearch.repository.ElasticSearchNativeQueryRepository;
import com.qt.ServiceElasticSearch.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ElasticSearchNativeQueryRepository elasticRepo;



    public List<ProductModel> getAllProduct() throws Exception {
        try {
            Iterable<ProductEntity> iterableProducts = productRepository.findAll();

            List<ProductEntity> listProducts = new ArrayList<>();
            List<ProductModel> listProductModels = new ArrayList<>();
            if (iterableProducts != null) {
                listProducts = StreamSupport.stream(iterableProducts.spliterator(), false).collect(Collectors.toList());

                for (ProductEntity product : listProducts) {
                    ProductModel productModel = new ProductModel();
                    productModel.setProductId(product.getId());
                    productModel.setProductId(product.getProductId());
                    productModel.setProductName(product.getProductName());
                    productModel.setCategory(product.getCategory());
                    DateTime date1 = this.convertStringToDate(product.getStartDateSell());
                    productModel.setPrice(product.getPrice());
                    productModel.setStartDateSell(date1);
                    productModel.setQuantity(product.getQuantity());
                    productModel.setDescription(product.getDescription());

                    listProductModels.add(productModel);
                }

            }

            return listProductModels;
        } catch (Exception e) {
//            logger.info("The connection with DB {} ",e);
            throw new Exception(e.getMessage());
        }

    }
    private DateTime convertStringToDate(String date) throws Exception {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(date);
            return localDateTime.toDateTime();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public List<ProductEntity> findProductByCategory(String category) throws Exception {
       SearchHits<ProductEntity> searchHits = elasticRepo.findProductByCategory(category);
       List<ProductEntity> listProducts = new ArrayList<>();
       if(searchHits != null){
           searchHits.stream().forEach(x -> {
                listProducts.add(x.getContent());
                logger.info("Result: {}", x);

            });
       }
       return listProducts;
    }





}
