package controllers.utils.sender;


import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import org.apache.commons.lang3.SerializationUtils;
import play.Logger;
import play.libs.Json;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class AsyncMessageProducer extends AsyncMessageSender {
    public AsyncMessageProducer(String queueName) throws IOException, TimeoutException {
        super(queueName);
    }

    public void sendMessage(AsyncMessagePojo asyncMessagePojo) throws IOException {
        this.channel.basicPublish("", this.queueName, null, Json.toJson(asyncMessagePojo).toString().getBytes());
        Logger.info("producer sent message type:{}", asyncMessagePojo.getClass());
    }
}
