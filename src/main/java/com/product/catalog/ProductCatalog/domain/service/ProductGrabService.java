package com.product.catalog.ProductCatalog.domain.service;

import com.product.catalog.ProductCatalog.domain.outputdata.GrabProductOutput;
import com.product.catalog.ProductCatalog.domain.outputdata.GrabProductOutputDataItem;
import com.product.catalog.ProductCatalog.domain.entity.Deal;
import com.product.catalog.ProductCatalog.external.reposatoryCalls.NoSqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductGrabService {
    @Autowired
    NoSqlService noSqlService;

    public GrabProductOutput ProductGrab(Long productId) {
        List<Deal> dealList = noSqlService.ProductGrabNoSqlService(productId);

        List<GrabProductOutputDataItem> grabProductOutputDataItemList =  new ArrayList();

        for(Deal d1: dealList) {
            log.info(d1.toString());
            grabProductOutputDataItemList.add(new GrabProductOutputDataItem(d1));

        }
        GrabProductOutput grapproductoutput;
        if(grabProductOutputDataItemList.size() > 0){
            grapproductoutput = new GrabProductOutput(grabProductOutputDataItemList, "Operation Success", "00");
        }else
        {
            log.info("No Deals for the product");
            grapproductoutput = new GrabProductOutput(grabProductOutputDataItemList, "Operation Failed", "404");
        }
        return grapproductoutput;


    }
}



