package com.product.catalog.ProductCatalog.domain.outputdata;

import java.util.List;

public class SearchProductOutput {
    List<SearchProductOutputDataItem> data;
    String resDesc;
    String resCode;

    public List<SearchProductOutputDataItem> getData() {
        return data;
    }

    public void setData(List<SearchProductOutputDataItem> data) {
        this.data = data;
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public SearchProductOutput(List<SearchProductOutputDataItem> data, String resDesc, String resCode) {
        this.data = data;
        this.resDesc = resDesc;
        this.resCode = resCode;
    }
}
