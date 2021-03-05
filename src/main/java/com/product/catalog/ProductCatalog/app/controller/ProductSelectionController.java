package com.product.catalog.ProductCatalog.app.controller;


import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.domain.SerchProductInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/book")
public class ProductSelectionController extends BaseController{

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findBook(@Validated @PathVariable Integer id, HttpServletRequest request) {
        setLogIdentifier(request);

        return new Product(5, "janitha");
    }

    @PostMapping(value = "/SearchProduct")
    public Map<Integer, Product> searchProduct(@RequestBody SerchProductInput newSerchProductInput) {

        Map<Integer, Product> productList = new HashMap();
        productList.put(1, new Product(1, "Nike T-Shirt"));
        return productList;
    }
}
