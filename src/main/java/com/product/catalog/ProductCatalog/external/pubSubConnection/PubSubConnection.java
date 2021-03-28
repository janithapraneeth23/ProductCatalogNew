package com.product.catalog.ProductCatalog.external.pubSubConnection;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.product.catalog.ProductCatalog.external.JsonMap.PubSubInput;
import com.product.catalog.ProductCatalog.external.reposatoryCalls.NoSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PubSubConnection {

    @Autowired
    NoSqlService noSqlService;

    @Value("${pubsub.projectId}")
    String projectId = "productcatelog";
    @Value("${pubsub.subscriptionId}")
    String subscriptionId = "janiSub";

    public void subscribeAsyncProductInput() throws Exception{
        ProjectSubscriptionName subscriptionName =
                ProjectSubscriptionName.of(projectId, subscriptionId);

        // Instantiate an asynchronous message receiver.
        MessageReceiver receiver =
                (PubsubMessage message, AckReplyConsumer consumer) -> {
                    // Handle incoming message, then ack the received message.
                    //System.out.println("Id: " + message.getMessageId());
                    //System.out.println("Data: " + message.getData().toStringUtf8());
                    consumer.ack();

                    PubSubInput productJson = null;
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        productJson = mapper.readValue(message.getData().toStringUtf8(), PubSubInput.class);
                        System.out.println(productJson);
                        noSqlService.addToTheDatabase(productJson);

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
