package com.product.catalog.ProductCatalog.external.storageCalls;

import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;

@Service
public class StorageCalls {

    public boolean saveImageToBucket(String image, String fileName) {
        try {
            String projectId = "productcatelog";
            String bucketName = "newproductcate";
            String objectName = fileName;
            String filePath = "/";
            System.out.println("Adding Image To Database");
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
            BlobId blobId = BlobId.of(bucketName, objectName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
            storage.create(blobInfo, image.getBytes());
            return true;
        }catch(Exception e){
            System.out.println("Saving Images to Bucket Failed");
            System.out.println(e.getMessage());
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
            System.out.println("Feting Image Failed");
            System.out.println(e.getMessage());
        }
        return new String("");
    }
}
