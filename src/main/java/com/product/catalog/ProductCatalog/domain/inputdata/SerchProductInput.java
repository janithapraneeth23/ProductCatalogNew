package com.product.catalog.ProductCatalog.domain.inputdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.product.catalog.ProductCatalog.app.validator.RequestEntityInterface;

import java.util.List;

public class SerchProductInput implements RequestEntityInterface {
    List<String> features;
    String mainFeature;

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getMainFeature() {
        return mainFeature;
    }

    public void setMainFeature(String mainFeature) {
        this.mainFeature = mainFeature;
    }

    //    public String getMainFeature() {
//        return mainFeature;
//    }
//
//    public void setMainFeature(String mainFeature) {
//        this.mainFeature = mainFeature;
//    }
//
//    @JsonCreator
//    public SerchProductInput(@JsonProperty("mainFeature") String mainFeature,  @JsonProperty("features") List<String> features) {
//        this.features = features;
//        this.mainFeature = mainFeature;
//    }
//
//    public List<String> getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(List<String> features) {
//        this.features = features;
//    }
}
