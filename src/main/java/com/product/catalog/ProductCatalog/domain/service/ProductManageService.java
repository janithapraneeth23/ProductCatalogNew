package com.product.catalog.ProductCatalog.domain.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.product.catalog.ProductCatalog.JsonMap.Products;
import com.product.catalog.ProductCatalog.JsonMap.ProductsItem;
import com.product.catalog.ProductCatalog.domain.Deal;
import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductManageService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    DealRepo dealRepo;

    @Bean
    public void saveProduct() {
       Set<String> tagList = new HashSet<String>();
       tagList.add("Nike");
       tagList.add("Black");
       Product p1 = new Product(555L, 12L, "Nike T-Shirt", "T-Shirt", "Nike T-Shirt Black", "Empty Image", tagList);
       Product savedProduct = productRepo.save(p1);
       savedProduct.getId();

       Deal d1 = new Deal(savedProduct.getId(), 024L, "Sampath", "Sampath Amex Credit Credit", "10% discount");
       dealRepo.save(d1);
        Deal d2 = new Deal(savedProduct.getId(), 024L, "NTB", "NTB Amex Credit Credit", "15% discount");
        dealRepo.save(d2);

       subscribeAsyncProductInput("productcatelog", "janiSub");


        //Optional<Product> p2 = productRepo.findByItemName("Adidas Tshirt");
       /* if(p2.isPresent()) {
            System.out.println(p2.toString());
        }*/
    }
    
    public static void subscribeAsyncProductInput(String projectId, String subscriptionId) {
        ProjectSubscriptionName subscriptionName =
                ProjectSubscriptionName.of(projectId, subscriptionId);

        // Instantiate an asynchronous message receiver.
        MessageReceiver receiver =
                (PubsubMessage message, AckReplyConsumer consumer) -> {
                    // Handle incoming message, then ack the received message.
                    System.out.println("Id: " + message.getMessageId());
                    System.out.println("Data: " + message.getData().toStringUtf8());
                    consumer.ack();

                    Products productJson = null;
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        productJson = mapper.readValue(message.getData().toStringUtf8(), Products.class);
                        for(ProductsItem productsItem : productJson.getProducts()){

                        }

                    } catch (JsonGenerationException e)
                    {
                        e.printStackTrace();
                    } catch (JsonMappingException e)
                    {
                        e.printStackTrace();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                };

        Subscriber subscriber = null;
        //try {
            subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
            // Start the subscriber.
            subscriber.startAsync().awaitRunning();
            System.out.printf("Listening for messages on %s:\n", subscriptionName.toString());
            // Allow the subscriber to run for 30s unless an unrecoverable error occurs.
            //subscriber.awaitTerminated(30, TimeUnit.SECONDS);
        /*} catch (TimeoutException timeoutException) {
            // Shut down the subscriber after 30s. Stop receiving messages.
            subscriber.stopAsync();
        }*/




    }

}
