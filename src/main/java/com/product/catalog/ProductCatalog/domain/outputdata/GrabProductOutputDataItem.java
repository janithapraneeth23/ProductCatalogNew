package com.product.catalog.ProductCatalog.domain.outputdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.product.catalog.ProductCatalog.domain.entity.Deal;

public class GrabProductOutputDataItem {

	@JsonProperty("offer")
	private String offer;

	@JsonProperty("bankCode")
	private Long bankCode;

	@JsonProperty("productId")
	private Long productId;

	@JsonProperty("cardName")
	private String cardName;

	@JsonProperty("dealId")
	private Long dealId;

	@JsonProperty("bankName")
	private String bankName;

	public String getOffer(){
		return offer;
	}

	public Long getBankCode(){
		return bankCode;
	}

	public Long getProductId(){
		return productId;
	}

	public String getCardName(){
		return cardName;
	}

	public Long getDealId(){
		return dealId;
	}

	public String getBankName(){
		return bankName;
	}

	public GrabProductOutputDataItem(Deal deal) {
		this.offer = deal.getOffer();
		this.bankCode = deal.getBankCode();
		this.productId = deal.getProductId();
		this.cardName = deal.getCardName();
		this.dealId = deal.getDealId();
		this.bankName = deal.getBankName();
	}
}