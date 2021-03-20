package com.product.catalog.ProductCatalog.external.JsonMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductItem {

	@JsonProperty("shopCode")
	private Long shopCode;

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

	@JsonProperty("shopName")
	private String shopName;

	@JsonProperty("description")
	private String description;

	public void setShopCode(Long shopCode){
		this.shopCode = shopCode;
	}

	public Long getShopCode(){
		return shopCode;
	}

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

	public void setShopName(String shopName){
		this.shopName = shopName;
	}

	public String getShopName(){
		return shopName;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}