package com.product.catalog.ProductCatalog.external.entity;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@Entity(name = "deals")
public class Deal {
    @Id
    Long dealId;

    Long productId;
    Long bankCode;
    String bankName;
    String cardName;
    String offer;

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBankCode() {
        return bankCode;
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public Deal(Long productId, Long bankCode, String bankName, String cardName, String offer) {
        this.productId = productId;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.cardName = cardName;
        this.offer = offer;
    }
}
