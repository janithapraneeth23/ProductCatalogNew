package com.product.catalog.ProductCatalog.domain.outputdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GrabProductOutput{

	@JsonProperty("data")
	private List<GrabProductOutputDataItem> data;

	public GrabProductOutput(List<GrabProductOutputDataItem> data, String resDesc, String resCode) {
		this.data = data;
		this.resDesc = resDesc;
		this.resCode = resCode;
	}

	@JsonProperty("resDesc")
	private String resDesc;

	@JsonProperty("resCode")
	private String resCode;

	public List<GrabProductOutputDataItem> getData(){
		return data;
	}

	public String getResDesc(){
		return resDesc;
	}

	public String getResCode(){
		return resCode;
	}
}