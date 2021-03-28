package com.product.catalog.ProductCatalog.external.reposatoryCalls;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.product.catalog.ProductCatalog.domain.entity.Deal;
import com.product.catalog.ProductCatalog.domain.entity.Product;
import com.product.catalog.ProductCatalog.external.JsonMap.OffersItem;
import com.product.catalog.ProductCatalog.external.JsonMap.ProductItem;
import com.product.catalog.ProductCatalog.external.JsonMap.PubSubInput;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class NoSqlService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    DealRepo dealRepo;

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

    @Value("gs://newproductcate/my-file.txt")
    private String gcsResource;

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
                System.out.println(savedProduct);
                savedProduct.getId();

                String projectId = "productcatelog";
                String bucketName = "newproductcate";
                String objectName = savedProduct.getId().toString();
                String filePath = "/";

                Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
                BlobId blobId = BlobId.of(bucketName, objectName);
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
                storage.create(blobInfo, productItem.getImage().getBytes());

                if(savedProduct.getId() > 0){
                    for(OffersItem offersItem : productItem.getOffers()){
                        Deal tmpDeal = new Deal(savedProduct.getId(), offersItem.getBankCode(), offersItem.getBankName(), offersItem.getCardName(), offersItem.getOffer());
                        dealRepo.save(tmpDeal);
                    }
                }


        }
    }

}
