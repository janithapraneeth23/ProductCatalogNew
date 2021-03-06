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

    public long getId() {
        return productId;
    }

    public void setId(long id) {
        this.productId = id;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public Deal(long id, String creditCardName, String offer) {
        this.productId = id;
        this.creditCardName = creditCardName;
        this.offer = offer;
    }
}
