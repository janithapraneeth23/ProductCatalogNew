package com.product.catalog.ProductCatalog.domain.service;

import com.product.catalog.ProductCatalog.domain.entity.Product;
import com.product.catalog.ProductCatalog.domain.outputdata.SearchProductOutput;
import com.product.catalog.ProductCatalog.domain.outputdata.SearchProductOutputDataItem;
import com.product.catalog.ProductCatalog.external.reposatoryCalls.NoSqlService;
import com.product.catalog.ProductCatalog.external.storageCalls.StorageCalls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ProductSelectionService {

    @Autowired
    NoSqlService noSqlService;

    @Autowired
    StorageCalls storageCalls;

    public SearchProductOutput ProductSelection(String mainFeature, Set<String> tagSet) {
        List<Product> productList = noSqlService.ProductSelectionNoSqlService(mainFeature);

        log.info("Product Count From Database: " +  productList.size());

        HashMap<Product, Integer> mapSortByTagCount = new HashMap();
        for(Product p1: productList) {
            Set<String> tagSetDB = new HashSet<>(p1.getTagSet());
            tagSetDB.retainAll(tagSet);
            if(tagSetDB.size()>0){
                mapSortByTagCount.put(p1, tagSetDB.size());
            }
        }
        LinkedHashMap<Product, Integer> reverseSortedMap = new LinkedHashMap<>();
        mapSortByTagCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));


        List<SearchProductOutputDataItem> searchProductOutputDataItemList =  new ArrayList();
        int itemCont = 0;
        for(Map.Entry<Product, Integer> p1: reverseSortedMap.entrySet()) {
            SearchProductOutputDataItem tmpOutputItem = new SearchProductOutputDataItem(p1.getKey());
            log.info("Product Filtered" + p1.toString());
            tmpOutputItem.setImage(storageCalls.fetchImageFromBucket(tmpOutputItem.getId().toString()));
            searchProductOutputDataItemList.add(tmpOutputItem);
            itemCont++;
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
