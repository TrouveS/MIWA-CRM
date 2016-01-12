package controllers.MonetaryController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.ServiceName;
import controllers.utils.sender.AsyncMessageConsumer;
import controllers.utils.sender.AsyncMessageProducer;
import controllers.utils.sender.SyncMessageSender;


import play.Logger;
import play.api.libs.json.Json;
import play.mvc.Result;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static play.mvc.Results.ok;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class Rating {

    /** Carte de la société venant de la Monetique  - Message synchrone**/
    public static Result getCarte() {
        Service service = Service.getInstances();

        try {
            //FIXME le chemin n'est pas le bon pour tester
            HttpResponse<JsonNode> jsonResponse = Unirest.post(service.getServiceHttpURL(ServiceName.MONETARY_SYSTEM) + "/CARTE")
                    .header("Content-type", "application/json")
                    .header("accept", "application/json")
                    .body(Json.toJson())
                    .asJson();

        } catch (UnirestException e) {
            e.printStackTrace();
        }

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
