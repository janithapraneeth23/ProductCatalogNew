package com.product.catalog.ProductCatalog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ProductCatalogApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ProductCatalogApplication.class, args);
		}catch(Exception e){
			log.info(e.getMessage());
		}
	}

}
