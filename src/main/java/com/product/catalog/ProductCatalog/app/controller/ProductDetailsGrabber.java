package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.inputdata.GrabProductInput;
import com.product.catalog.ProductCatalog.domain.outputdata.GrabProductOutput;
import com.product.catalog.ProductCatalog.domain.service.ProductGrabService;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductDetailsGrabber {

    @Autowired
    DealRepo dealRepo;

    @Autowired
    ProductGrabService productGrabService;

    @PostMapping(value = "/GrapBestDeal")
    public GrabProductOutput searchDeals(@RequestBody GrabProductInput newGrabProductInput) throws Exception{
        Long productId = newGrabProductInput.getProductId();
        return productGrabService.ProductGrab(productId);
    }
}

