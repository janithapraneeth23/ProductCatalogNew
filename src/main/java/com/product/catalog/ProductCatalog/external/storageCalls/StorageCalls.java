package com.product.catalog.ProductCatalog.external.storageCalls;

import com.google.cloud.storage.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageCalls {

    public boolean saveImageToBucket(String image, String fileName) {
        try {
            String projectId = "productcatelog";
            String bucketName = "newproductcate";
            String objectName = fileName;
            String filePath = "/";
            log.info("Adding Image To Database");
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
            BlobId blobId = BlobId.of(bucketName, objectName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
            storage.create(blobInfo, image.getBytes());
            return true;
        }catch(Exception e){
            log.error("Saving Images to Bucket Failed");
            log.error(e.getMessage());
        }
        return false;
    }

    public String fetchImageFromBucket(String fileName) {
        try {
            String projectId = "productcatelog";
            String bucketName = "newproductcate";
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
            Blob blob = storage.get(BlobId.of(bucketName, fileName));
            return new String(blob.getContent());
        }catch(Exception e){
            log.error("Fetching Image Failed");
            log.error(e.getMessage());
        }
        return new String("");
    }
}
