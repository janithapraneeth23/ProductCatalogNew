package com.product.catalog.ProductCatalog.domain.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.product.catalog.ProductCatalog.JsonMap.OffersItem;
import com.product.catalog.ProductCatalog.JsonMap.Products;
import com.product.catalog.ProductCatalog.JsonMap.ProductsItem;
import com.product.catalog.ProductCatalog.domain.Deal;
import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.external.reposatory.DealRepo;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${pubsub.projectId}")
    private String projectId;
    @Value("${pubsub.subscriptionId}")
    private String subscriptionId;


    @Bean
    public void saveProduct() {
       subscribeAsyncProductInput("productcatelog", "janiSub");
       //projectId.toString(), subscriptionId.toString());
    }

    public void addToTheDatabase(Products productJson){
        for(ProductsItem productsItem : productJson.getProducts())
        {
            String tagString = productsItem.getDesctiption() + " " + productsItem.getItemName();
            String [] tags = tagString.split(" ");
            Set<String> tagList = new HashSet<>();
            for(String tag: tags)
                tagList.add(tag);

            tagList.remove(productsItem.getItemType());

            Product p2 = new Product( productsItem.getItemCode(), productJson.getShopCode(),  productsItem.getItemName(), productsItem.getItemType(), productsItem.getDesctiption(),
                    productsItem.getImage(), tagList);
            Product savedProduct = productRepo.save(p2);
            savedProduct.getId();

            if(savedProduct.getId() > 0){
                for(OffersItem deal : productsItem.getOffers()){
                    Deal tmpDeal = new Deal(savedProduct.getId(), deal.getBankCode(), deal.getBankName(), deal.getCardName(), deal.getOffer());
                    dealRepo.save(tmpDeal);
                }


            }
        }
    }
    public void subscribeAsyncProductInput(String projectId, String subscriptionId) {
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
                        addToTheDatabase(productJson);

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
