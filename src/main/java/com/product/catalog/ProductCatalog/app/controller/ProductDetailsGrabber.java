package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.BestDeals;
import com.product.catalog.ProductCatalog.domain.Deal;
import com.product.catalog.ProductCatalog.domain.inputdata.GrabProductInput;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductDetailsGrabber {

    @Autowired
    DealRepo dealRepo;

    @PostMapping(value = "/GrapBastDeal")
    public BestDeals searchDeals(@RequestBody GrabProductInput newGrabProductInput) {

        long productId = newGrabProductInput.getProductId();
        Optional<Deal> dealItem =  dealRepo.findAllByProductId(productId);
        Map<Long, Deal> dealList = new HashMap();
        if(dealItem.isPresent()) {
            dealList.put(productId, dealItem.get());
        }

        BestDeals bd = new BestDeals(productId, "Test",dealList);
        return bd;
    }
}

