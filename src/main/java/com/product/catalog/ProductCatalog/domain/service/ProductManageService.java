package com.product.catalog.ProductCatalog.domain.service;

import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductManageService {
    @Autowired
    ProductRepo productRepo;
    @Bean
    public void saveProduct() {
        Product p1 = new Product(5, "Adidas Tshirt");
        productRepo.save(p1);

        Optional<Product> p2 = productRepo.findByItemName("Adidas Tshirt");
        if(p2.isPresent()) {
            System.out.println(p2.toString());
        }
    }

}
