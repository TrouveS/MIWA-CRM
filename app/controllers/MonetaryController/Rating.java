package controllers.MonetaryController;

import controllers.utils.sender.AsyncMessageConsumer;
import controllers.utils.sender.AsyncMessageProducer;
import controllers.utils.sender.SyncMessageSender;


import play.Logger;
import play.mvc.Result;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static play.mvc.Results.ok;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class Rating {

    /** Envoie du Rating à la  Monetique**/
    public static Result sendRating() {
        try {
            AsyncMessageConsumer rating = new AsyncMessageConsumer("RATING");
            Thread ratingThread = new Thread(rating);
            ratingThread.start();
            Logger.info("client message in queue {}", "RATING");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return ok();
    }

    /** Envoie du Risque à la Monetique**/

    public static Result sendRisk() {
        try {
            AsyncMessageConsumer risque = new AsyncMessageConsumer("RISK");
            Thread risqueThread = new Thread(risque);
            risqueThread.start();
            Logger.info("client message in queue {}", "RISK");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return ok();
    }



}
