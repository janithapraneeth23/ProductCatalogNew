package com.product.catalog.ProductCatalog.domain.service;

import com.product.catalog.ProductCatalog.domain.Product2;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class productmanageservice {
    @Autowired
    ProductRepo productRepo;
    @Bean
    public void saveProduct() {
        Product2 p1 = new Product2(5, "Adidas Tshirt", "Reeee");
        productRepo.save(p1);

        Optional<Product2> p2 = productRepo.findByItemName("Adidas Tshirt");
        if(p2.isPresent()) {
            System.out.println(p2.toString());
        }
    }

}
