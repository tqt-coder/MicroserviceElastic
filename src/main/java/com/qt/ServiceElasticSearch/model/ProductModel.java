package com.qt.ServiceElasticSearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    private String id;
    private String productId;

    private String productName;

    private String category;

    private Double price;

    private DateTime startDateSell;

    private Integer quantity;

    private String description;




}
