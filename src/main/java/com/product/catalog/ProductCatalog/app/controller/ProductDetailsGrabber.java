package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.BestDeals;
import com.product.catalog.ProductCatalog.domain.Deal;
import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.domain.inputdata.GrabProductInput;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductDetailsGrabber {

    @Autowired
    DealRepo dealRepo;

    @PostMapping(value = "/GrapBestDeal")
    public BestDeals searchDeals(@RequestBody GrabProductInput newGrabProductInput) {

        long productId = newGrabProductInput.getProductId();
        Optional<List<Deal>> dealItem =  dealRepo.findAllByProductId(productId);
        if(dealItem.isPresent()) {
            List<Deal> nonOptionalData = dealItem.get();
            BestDeals bd = new BestDeals(productId, "Test",nonOptionalData);
            return bd;
        }
        List<Deal> dealList = new ArrayList();
        BestDeals bd = new BestDeals(productId, "Test",dealList);
        return bd;
    }
}

