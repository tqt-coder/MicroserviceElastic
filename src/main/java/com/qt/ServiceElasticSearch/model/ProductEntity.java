package com.qt.ServiceElasticSearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "blog2", type = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    private Long key;

    private DateTime eventDate;

    private DateTime modified;

    private String countryCode;

    private String datasetName;

    private String language;

    private String minimumDistanceAboveSurfaceInMeters;

}

