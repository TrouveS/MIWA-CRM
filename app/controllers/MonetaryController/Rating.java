package controllers.MonetaryController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.ServiceName;
import controllers.utils.pojo.SyncMessagePojo.RatingPojo;
import controllers.utils.sender.AsyncMessageConsumer;
import controllers.utils.sender.AsyncMessageProducer;
import controllers.utils.sender.SyncMessageSender;


import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static play.mvc.Results.ok;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class Rating extends Controller{

    /** Carte de la société venant de la Monetique  - Message synchrone**/
    public static Result getCarte() {
        Service service = Service.getInstances();
        JsonNode json = request().body().asJson();
        RatingPojo pojo = Json.fromJson(json, RatingPojo.class);

        return ok();
    }


    /** Envoie du Rating à la  Monetique**/
    public static Result sendRating() {

        return ok();
    }

    /** Envoie du Risque à la Monetique**/

    public static Result sendRisk() {

        return ok();
    }



}
