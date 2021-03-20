package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.inputdata.SerchProductInput;
import com.product.catalog.ProductCatalog.domain.outputdata.SearchProductOutput;
import com.product.catalog.ProductCatalog.domain.service.ProductSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/products")
public class ProductSelectionController extends BaseController{

    @Autowired
    ProductSelectionService productSelectionService;

    @PostMapping(value = "/SearchProduct")
    public SearchProductOutput searchProduct(@RequestBody SerchProductInput newSerchProductInput) throws Exception {

        //controller
        String mainFeature = newSerchProductInput.getMainFeature();
        List<String> features = newSerchProductInput.getFeatures();
        Set<String> tagSet = new HashSet<>(features);

        //domain call
        return productSelectionService.ProductSelection(mainFeature, tagSet);
    }
}
