package com.product.catalog.ProductCatalog.JsonMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Products{

	@JsonProperty("shopCode")
	private Long shopCode;

	@JsonProperty("products")
	private List<ProductsItem> products;

	public void setShopCode(Long shopCode){
		this.shopCode = shopCode;
	}

	public Long getShopCode(){
		return shopCode;
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}
}