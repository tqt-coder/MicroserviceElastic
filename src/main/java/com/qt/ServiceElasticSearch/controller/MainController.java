package com.qt.ServiceElasticSearch.controller;

        import com.qt.ServiceElasticSearch.model.ProductEntity;
        import com.qt.ServiceElasticSearch.model.ProductModel;
        import com.qt.ServiceElasticSearch.service.ProductService;
        import org.apache.http.protocol.HTTP;
        import org.elasticsearch.action.search.SearchRequest;
        import org.elasticsearch.action.search.SearchResponse;
        import org.elasticsearch.action.search.SearchType;
        import org.elasticsearch.client.Client;
        import org.elasticsearch.client.RestHighLevelClient;
        import org.elasticsearch.index.query.QueryBuilders;
        import org.elasticsearch.search.builder.SearchSourceBuilder;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;


@RestController
public class MainController {

    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/v1/products")
    public ResponseEntity<?> getAllProducts() throws Exception {
        List<ProductModel> listProduct = productService.getAllProduct();
        log.debug("object {}", listProduct.toArray());
        return new ResponseEntity<>(listProduct.toString(), HttpStatus.OK);
    }

    @GetMapping("/v1/products/{paramCategory}")
    public ResponseEntity<?> handleSearch(@PathVariable("paramCategory") String paramCategory) throws Exception {

        List<ProductEntity> listProducts = productService.findProductByCategory(paramCategory);
        return new ResponseEntity<>(listProducts, HttpStatus.OK);
    }


}
