package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Clients;
import play.Logger;
import play.api.mvc.Result;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class RatingPojo extends AsyncMessagePojo {
    private long idfidelite;
    private  int rating;
    RatingPojo ratingPojo;

    public RatingPojo() {
    }

    public void action(){
        ratingPojo = new RatingPojo();
        Clients client;
        client = Clients.find.where().eq("idFidelite", idfidelite).findUnique();

        if (client != null) {
            ratingPojo.idfidelite = idfidelite;
            ratingPojo.rating = client.getRating();
        }
    }
}

