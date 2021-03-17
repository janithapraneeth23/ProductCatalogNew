package com.product.catalog.ProductCatalog.JsonMap;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private Integer itemCode;

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

	public void setItemCode(Integer itemCode){
		this.itemCode = itemCode;
	}

	public Integer getItemCode(){
		return itemCode;
	}

	public void setDesctiption(String desctiption){
		this.desctiption = desctiption;
	}

	public String getDesctiption(){
		return desctiption;
	}
}