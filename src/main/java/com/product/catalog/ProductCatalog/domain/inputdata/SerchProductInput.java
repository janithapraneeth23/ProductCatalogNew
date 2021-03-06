package com.product.catalog.ProductCatalog.domain.inputdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SerchProductInput {
    String productWildCard;
    @JsonCreator
    public SerchProductInput(@JsonProperty("productWildCard") String productWildCard) {
        this.productWildCard = productWildCard;
    }

    public String getProductWildCard() {
        return productWildCard;
    }

    public void setProductWildCard(String productWildCard) {
        this.productWildCard = productWildCard;
    }
}
