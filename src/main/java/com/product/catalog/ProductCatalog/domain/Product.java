package com.product.catalog.ProductCatalog.domain;

import lombok.ToString;
import org.springframework.data.annotation.Id;
@ToString
public class Product {

    @Id
    long productId;
    String itemName;
    String type;

    public void setId(long id) {
        this.productId = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product(long id, String itemName) {
        this.productId = id;
        this.itemName = itemName;
    }

    public long getId() {
        return productId;
    }

    public void setId(int id) {
        this.productId = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
