package com.product.catalog.ProductCatalog.app.exception.type;

import com.product.catalog.ProductCatalog.app.validator.RequestEntityInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import java.util.Set;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {
    private Set<ConstraintViolation<RequestEntityInterface>> errors;

    public ValidationException(Set<ConstraintViolation<RequestEntityInterface>> errors){
        this.errors = errors;
    }
    public Set<ConstraintViolation<RequestEntityInterface>> getErrors() {
        return this.errors;
    }

}
