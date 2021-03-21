package com.product.catalog.ProductCatalog.domain.service;

import com.product.catalog.ProductCatalog.external.pubSubConnection.PubSubConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProductManageService {

    @Autowired
    PubSubConnection pubSubConnection;

    @Bean
    public void saveProduct() throws Exception {
        pubSubConnection.subscribeAsyncProductInput();
    }

}
