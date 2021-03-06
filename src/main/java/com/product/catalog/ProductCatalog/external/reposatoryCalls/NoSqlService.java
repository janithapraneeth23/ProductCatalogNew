package com.product.catalog.ProductCatalog.external.reposatoryCalls;

import com.product.catalog.ProductCatalog.domain.entity.Deal;
import com.product.catalog.ProductCatalog.domain.entity.Product;
import com.product.catalog.ProductCatalog.external.JsonMap.OffersItem;
import com.product.catalog.ProductCatalog.external.JsonMap.ProductItem;
import com.product.catalog.ProductCatalog.external.JsonMap.PubSubInput;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import com.product.catalog.ProductCatalog.external.storageCalls.StorageCalls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class NoSqlService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DealRepo dealRepo;
    @Autowired
    StorageCalls storageCalls;

    public List<Product> ProductSelectionNoSqlService(String mainFeature) {
        Optional<List<Product>> productItemWithoutFilter = productRepo.findByItemType(mainFeature);
        if(productItemWithoutFilter.isPresent()) {
            return productItemWithoutFilter.get();
        }
        return new ArrayList<>();
    }

    public List<Deal> ProductGrabNoSqlService(Long productId) {

        Optional<List<Deal>> dealItem =  dealRepo.findAllByProductId(productId);
        if(dealItem.isPresent()) {
            return dealItem.get();
        }
        return new ArrayList<>();
    }

    public void addToTheDatabase(PubSubInput pubSubInput)  throws IOException {
        for(ProductItem productItem : pubSubInput.getData())
        {
            String tagString = productItem.getDescription()  + " " + productItem.getItemName();
            String [] tags = tagString.split(" ");
            Set<String> tagList = new HashSet<>();
            for(String tag: tags)
                tagList.add(tag);

                tagList.remove(productItem.getItemType());

                Product p2 = new Product( productItem.getItemCode(), productItem.getShopCode(), productItem.getShopName(), productItem.getItemName(), productItem.getItemType(), productItem.getDescription(),
                    "", tagList);

                Product savedProduct = productRepo.save(p2);
                log.info("Adding Items To Database");
                log.info(savedProduct.toString());
                savedProduct.getId();

                storageCalls.saveImageToBucket(productItem.getImage(), savedProduct.getId().toString());

                if(savedProduct.getId() > 0){
                    for(OffersItem offersItem : productItem.getOffers()){
                        Deal tmpDeal = new Deal(savedProduct.getId(), offersItem.getBankCode(), offersItem.getBankName(), offersItem.getCardName(), offersItem.getOffer());
                        dealRepo.save(tmpDeal);
                    }
                }


        }
    }

}
