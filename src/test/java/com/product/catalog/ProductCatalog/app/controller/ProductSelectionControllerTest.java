package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.domain.service.ProductGrabService;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import com.product.catalog.ProductCatalog.external.reposatoryCalls.NoSqlService;
import com.product.catalog.ProductCatalog.external.storageCalls.StorageCalls;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductSelectionControllerTest {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DealRepo dealRepo;

    @Autowired
    StorageCalls storageCalls;

    @Autowired
    NoSqlService noSqlService;

    @Autowired
    ProductGrabService productGrabService;

    @Test
    public void searchProduct() throws Exception{
        //ProductSelectionController controller = new ProductSelectionController();
        //ResponseEntity<GrabProductOutput> grabProductOutputResponseEntity = controller.searchDeals(545453456436436L);


    }

    @Test
    public void searchDeals() {
    }
}