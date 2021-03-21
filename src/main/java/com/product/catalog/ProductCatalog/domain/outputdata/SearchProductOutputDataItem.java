package com.product.catalog.ProductCatalog.domain.outputdata;

import com.product.catalog.ProductCatalog.domain.entity.Product;

public class SearchProductOutputDataItem {

    Long id;
    Long itemCode;
    Long shopCode;
    String shopName;
    String itemName;
    String itemType;
    String description;
    String image;

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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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

    public SearchProductOutputDataItem(Product entityProduct) {
        this.id = entityProduct.getId();
        this.itemCode = entityProduct.getItemCode();
        this.shopCode = entityProduct.getShopCode();
        this.shopName = entityProduct.getShopName();
        this.itemName = entityProduct.getItemName();
        this.itemType = entityProduct.getItemType();
        this.description = entityProduct.getDescription();
        this.image = entityProduct.getImage();
    }
}
