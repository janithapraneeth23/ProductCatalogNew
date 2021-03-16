package com.product.catalog.ProductCatalog.domain.service;

import com.product.catalog.ProductCatalog.domain.Product;
import com.product.catalog.ProductCatalog.external.reposatory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class ProductManageService {
    @Autowired
    ProductRepo productRepo;
    @Bean
    public void saveProduct() {
       // Product p1 = new Product(5, "Adidas", "T-Shirt" , "New");
       // productRepo.save(p1);

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
