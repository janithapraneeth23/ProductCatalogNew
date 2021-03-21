package com.product.catalog.ProductCatalog.external.reposatory;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.product.catalog.ProductCatalog.domain.entity.Product;

import java.util.*;

public interface ProductRepo extends DatastoreRepository<Product, Long> {
    public Optional<List<Product>> findByItemName(String itemName);

    public Optional<List<Product>> findByItemType(String itemType);
}

