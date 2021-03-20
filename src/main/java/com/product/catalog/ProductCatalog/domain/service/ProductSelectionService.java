package com.product.catalog.ProductCatalog.domain.service;

import com.product.catalog.ProductCatalog.external.entity.Product;
import com.product.catalog.ProductCatalog.domain.outputdata.SearchProductOutput;
import com.product.catalog.ProductCatalog.domain.outputdata.SearchProductOutputDataItem;
import com.product.catalog.ProductCatalog.external.reposatoryCalls.NoSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductSelectionService {

    @Autowired
    NoSqlService noSqlService;

    public SearchProductOutput ProductSelection(String mainFeature, Set<String> tagSet) {
        List<Product> productList = noSqlService.ProductSelectionNoSqlService(mainFeature);

        int itemCont = 0;
        List<SearchProductOutputDataItem> searchProductOutputDataItemList =  new ArrayList();

        for(Product p1: productList) {
            Set<String> tagSetDB = new HashSet<>(p1.getTagSet());
            tagSetDB.retainAll(tagSet);
            if(tagSetDB.size()>0){
                searchProductOutputDataItemList.add(new SearchProductOutputDataItem(p1));
                itemCont++;
            }
            if(itemCont >= 10)
                break;
        }

        if(itemCont > 0) {
            SearchProductOutput grapproductoutput = new SearchProductOutput(searchProductOutputDataItemList, "Operation Success", "00");
            return grapproductoutput;
        }else{
            SearchProductOutput grapproductoutput = new SearchProductOutput(searchProductOutputDataItemList, "Operation Failed", "404");
            return grapproductoutput;
        }
    }
}
