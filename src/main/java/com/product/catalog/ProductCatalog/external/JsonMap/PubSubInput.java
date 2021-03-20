package com.product.catalog.ProductCatalog.external.JsonMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PubSubInput{

	@JsonProperty("data")
	private List<ProductItem> data;

	public void setData(List<ProductItem> data){
		this.data = data;
	}

	public List<ProductItem> getData(){
		return data;
	}
}