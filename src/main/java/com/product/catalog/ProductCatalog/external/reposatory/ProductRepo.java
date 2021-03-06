package com.product.catalog.ProductCatalog.external.reposatory;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.product.catalog.ProductCatalog.domain.Product2;

import java.util.Optional;

public interface ProductRepo extends DatastoreRepository<Product2, Long> {
    public Optional<Product2> findByItemName(String itemName);
    public Optional<Product2> findByitemName(String itemName);
}
