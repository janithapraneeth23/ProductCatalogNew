package com.product.catalog.ProductCatalog.domain.inputdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SerchProductInput {
    String productWildCard;
    String mainFeature;

    public String getMainFeature() {
        return mainFeature;
    }

    public void setMainFeature(String mainFeature) {
        this.mainFeature = mainFeature;
    }

    @JsonCreator
    public SerchProductInput(@JsonProperty("mainFeature") String mainFeature,  @JsonProperty("productWildCard") String productWildCard) {
        this.productWildCard = productWildCard;
        this.mainFeature = mainFeature;
    }

    public String getProductWildCard() {
        return productWildCard;
    }

    public void setProductWildCard(String productWildCard) {
        this.productWildCard = productWildCard;
    }
}
