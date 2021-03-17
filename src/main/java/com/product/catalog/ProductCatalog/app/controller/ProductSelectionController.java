package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.domain.inputdata.SerchProductInput;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/products")
public class ProductSelectionController extends BaseController{

    @Autowired
    ProductRepo productRepo;

    @PostMapping(value = "/SearchProduct")
    public List<Product> searchProduct(@RequestBody SerchProductInput newSerchProductInput) {

        String mainFeature = newSerchProductInput.getMainFeature();
        String productWildCard = newSerchProductInput.getProductWildCard();
        String [] tags = productWildCard.split("\\|");
        Set<String> tagSet = new HashSet<>();
        for(String tag: tags)
            tagSet.add(tag);


        Optional<List<Product>> productItemWithoutFilter =  productRepo.findByItemType(mainFeature);
        if(productItemWithoutFilter.isPresent()) {
            List<Product> nonOptionalData = productItemWithoutFilter.get();
            List<Product> tmps = new ArrayList<>();
            for(Product p1: nonOptionalData) {
                Set<String> tagSetDB = p1.getTagSet();
                tagSet.retainAll(tagSetDB);
                if(tagSet.size()>0){
                    tmps.add(p1);
                }
            }
            return tmps;
        }
        List<Product> productList = new ArrayList();
        return productList;
    }
}
