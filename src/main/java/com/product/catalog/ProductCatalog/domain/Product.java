package com.product.catalog.ProductCatalog.domain;

import lombok.ToString;
import org.springframework.data.annotation.Id;
@ToString
public class Product {

    @Id
    long productId;
    String itemName;
    String type;
    String desctiption;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }



    public void setType(String type) {
        this.type = type;
    }

    public Product(long productId, String itemName, String type, String desctiption) {
        this.productId = productId;
        this.itemName = itemName;
        this.type = type;
        this.desctiption = desctiption;
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
