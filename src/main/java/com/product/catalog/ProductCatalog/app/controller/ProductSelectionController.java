package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.domain.inputdata.SerchProductInput;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/products")
public class ProductSelectionController extends BaseController{

   /* @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findBook(@Validated @PathVariable Integer id, HttpServletRequest request) {
        setLogIdentifier(request);

        return new Product(5, "janitha");
    }*/

    @PostMapping(value = "/SearchProduct")
    public Map<Integer, Product> searchProduct(@RequestBody SerchProductInput newSerchProductInput) {

        Map<Integer, Product> productList = new HashMap();
        //productList.put(1, new Product2(1, "Nike T-Shirt"));
        return productList;
    }
}
