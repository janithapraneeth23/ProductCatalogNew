package com.product.catalog.ProductCatalog.JsonMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductsItem{

	@JsonProperty("offers")
	private List<OffersItem> offers;

	@JsonProperty("image")
	private String image;

	@JsonProperty("itemName")
	private String itemName;

	@JsonProperty("itemType")
	private String itemType;

	@JsonProperty("itemCode")
	private Long itemCode;

	@JsonProperty("desctiption")
	private String desctiption;

	public void setOffers(List<OffersItem> offers){
		this.offers = offers;
	}

	public List<OffersItem> getOffers(){
		return offers;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemName(){
		return itemName;
	}

	public void setItemType(String itemType){
		this.itemType = itemType;
	}

	public String getItemType(){
		return itemType;
	}

	public void setItemCode(Long itemCode){
		this.itemCode = itemCode;
	}

	public Long getItemCode(){
		return itemCode;
	}

	public void setDesctiption(String desctiption){
		this.desctiption = desctiption;
	}

	public String getDesctiption(){
		return desctiption;
	}
}