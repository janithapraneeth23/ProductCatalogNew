package com.product.catalog.ProductCatalog.domain;

import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Map;

@ToString
public class BestDeals {
    @Id
    long productId;
    String itemName;
    Map<Long, Deal> dealList;

    public long getId() {
        return productId;
    }

    public void setId(long id) {
        this.productId = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Map<Long, Deal> getDealList() {
        return dealList;
    }

    public void setDealList(Map<Long, Deal> dealList) {
        this.dealList = dealList;
    }

    public BestDeals(long id, String itemName, Map<Long, Deal> dealList) {
        this.productId = id;
        this.itemName = itemName;
        this.dealList = dealList;
    }
}
