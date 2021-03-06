package com.product.catalog.ProductCatalog.app.controller;


import com.product.catalog.ProductCatalog.domain.Product2;
import com.product.catalog.ProductCatalog.domain.SerchProductInput;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/book")
public class ProductSelectionController extends BaseController{

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product2 findBook(@Validated @PathVariable Integer id, HttpServletRequest request) {
        setLogIdentifier(request);

        return new Product2(5, "janitha", "trtr");
    }

    @PostMapping(value = "/SearchProduct")
    public Map<Integer, Product2> searchProduct(@RequestBody SerchProductInput newSerchProductInput) {

        Map<Integer, Product2> productList = new HashMap();
        //productList.put(1, new Product2(1, "Nike T-Shirt"));
        return productList;
    }
}
