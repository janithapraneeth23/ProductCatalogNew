package com.product.catalog.ProductCatalog.external.exception;

import com.product.catalog.ProductCatalog.app.exception.type.BaseException;

public class DatastoreException extends BaseException {
    public DatastoreException(String message) {
        super(message);
    }

    public DatastoreException(String message, String code) {
        super(message, code);
    }
}
