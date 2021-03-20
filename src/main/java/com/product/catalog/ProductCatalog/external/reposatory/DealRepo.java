package com.product.catalog.ProductCatalog.external.reposatory;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.product.catalog.ProductCatalog.external.entity.Deal;

import java.util.*;

public interface DealRepo extends DatastoreRepository<Deal, Long> {
    public Optional<List<Deal>> findAllByProductId(long productId);
}