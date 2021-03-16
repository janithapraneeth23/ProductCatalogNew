package com.product.catalog.ProductCatalog.domain;

import lombok.ToString;
import org.springframework.data.annotation.Id;
@ToString
public class Deal {
    @Id
    long dealId;
    long productId;
    String creditCardName;
    String offer;

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public Deal(long dealId, long productId, String creditCardName, String offer) {
        this.dealId = dealId;
        this.productId = productId;
        this.creditCardName = creditCardName;
        this.offer = offer;
    }
}
