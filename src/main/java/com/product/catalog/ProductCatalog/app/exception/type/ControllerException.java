package com.product.catalog.ProductCatalog.app.exception.type;

public class ControllerException extends BaseException {
    public ControllerException(String message){
        super(message);
    }
    public ControllerException(String message, String code){
        super(message,code);
    }
}
