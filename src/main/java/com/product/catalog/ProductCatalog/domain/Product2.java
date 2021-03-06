package com.product.catalog.ProductCatalog.domain;

import lombok.ToString;
import org.springframework.data.annotation.Id;
@ToString
public class Product2 {

    @Id
    long id;
    String itemName;
    String ItemName;
    String type;

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product2(long id, String itemName, String ItemName) {
        this.id = id;
        this.itemName = itemName;
        this.ItemName = ItemName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
