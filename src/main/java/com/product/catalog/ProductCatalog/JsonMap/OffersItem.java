package com.product.catalog.ProductCatalog.JsonMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OffersItem{

	@JsonProperty("offer")
	private String offer;

	@JsonProperty("bankCode")
	private String bankCode;

	@JsonProperty("CardName")
	private String cardName;

	@JsonProperty("bankName")
	private String bankName;

	public void setOffer(String offer){
		this.offer = offer;
	}

	public String getOffer(){
		return offer;
	}

	public void setBankCode(String bankCode){
		this.bankCode = bankCode;
	}

	public String getBankCode(){
		return bankCode;
	}

	public void setCardName(String cardName){
		this.cardName = cardName;
	}

	public String getCardName(){
		return cardName;
	}

	public void setBankName(String bankName){
		this.bankName = bankName;
	}

	public String getBankName(){
		return bankName;
	}
}