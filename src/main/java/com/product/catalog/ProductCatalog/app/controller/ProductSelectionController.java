package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.inputdata.SerchProductInput;
import com.product.catalog.ProductCatalog.domain.outputdata.GrabProductOutput;
import com.product.catalog.ProductCatalog.domain.outputdata.SearchProductOutput;
import com.product.catalog.ProductCatalog.domain.service.ProductGrabService;
import com.product.catalog.ProductCatalog.domain.service.ProductSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "${base-url.context}/product")
public class ProductSelectionController extends BaseController{

    @Autowired
    ProductSelectionService productSelectionService;

    @Autowired
    ProductGrabService productGrabService;

    @PostMapping(value = "/search-product", produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchProductOutput searchProduct(@Validated  @RequestBody SerchProductInput serchProductInput) throws Exception {

        //controller
        String mainFeature = serchProductInput.getMainFeature();
        List<String> features = serchProductInput.getFeatures();
        System.out.println("Feature List");
        System.out.println(features);
        Set<String> tagSet = new HashSet<>(features);

        //domain call
        return productSelectionService.ProductSelection(mainFeature, tagSet);
    }



    @GetMapping(value = "/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GrabProductOutput>  searchDeals(@Validated @PathVariable("productId")Long productId) throws Exception{

        GrabProductOutput grabProductOutput =  productGrabService.ProductGrab(productId);
        return ResponseEntity.status(HttpStatus.OK).body(grabProductOutput);

    }
}
