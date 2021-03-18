package com.product.catalog.ProductCatalog.domain.inputdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SerchProductInput {
    String features;
    String mainFeature;

    public String getMainFeature() {
        return mainFeature;
    }

    public void setMainFeature(String mainFeature) {
        this.mainFeature = mainFeature;
    }

    @JsonCreator
    public SerchProductInput(@JsonProperty("mainFeature") String mainFeature,  @JsonProperty("features") String features) {
        this.features = features;
        this.mainFeature = mainFeature;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
}
