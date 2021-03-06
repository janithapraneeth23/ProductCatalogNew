package com.product.catalog.ProductCatalog.external.reposatory;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.product.catalog.ProductCatalog.domain.Deal;
import com.product.catalog.ProductCatalog.domain.Product;

import java.util.Optional;

public interface DealRepo extends DatastoreRepository<Deal, Long> {
    public Optional<Deal> findAllByProductId(long productId);
}