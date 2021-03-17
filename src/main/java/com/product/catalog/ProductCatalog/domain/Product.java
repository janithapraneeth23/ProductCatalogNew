package com.product.catalog.ProductCatalog.domain;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;

import java.util.Set;

@ToString
@Entity(name = "products")
public class Product {

    @Id
    Long id;

    Long itemCode;
    Long shopCode;
    String itemName;
    String itemType;
    String description;
    String image;
    Set<String> tagSet;

    public Product(Long itemCode, Long shopCode, String itemName, String itemType, String description, String image, Set<String> tagSet) {
        this.itemCode = itemCode;
        this.shopCode = shopCode;
        this.itemName = itemName;
        this.itemType = itemType;
        this.description = description;
        this.image = image;
        this.tagSet = tagSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public Long getShopCode() {
        return shopCode;
    }

    public void setShopCode(Long shopCode) {
        this.shopCode = shopCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<String> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<String> tagSet) {
        this.tagSet = tagSet;
    }
}
