package com.product.catalog.ProductCatalog.external.reposatory;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.product.catalog.ProductCatalog.domain.Product;

import java.util.Optional;

public interface ProductRepo extends DatastoreRepository<Product, Long> {
    public Optional<Product> findByItemName(String itemName);
}

