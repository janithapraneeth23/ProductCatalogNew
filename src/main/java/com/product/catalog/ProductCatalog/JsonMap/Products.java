package com.product.catalog.ProductCatalog.JsonMap;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Products{

	@JsonProperty("shopCode")
	private Integer shopCode;

	@JsonProperty("products")
	private List<ProductsItem> products;

	public void setShopCode(Integer shopCode){
		this.shopCode = shopCode;
	}

	public Integer getShopCode(){
		return shopCode;
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}
}