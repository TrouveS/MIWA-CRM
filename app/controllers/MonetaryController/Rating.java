package controllers.MonetaryController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.ServiceName;
import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.CartePojo;


import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.RatingPojo;
import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.RiskPojo;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static play.mvc.Results.ok;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class Rating extends Controller{

    /** Carte de la société venant de la Monetique  - Message synchrone**/
    public static Result getCarte() {
        Service service = Service.getInstances();
        JsonNode json = request().body().asJson();
        CartePojo pojo = Json.fromJson(json, CartePojo.class);

        return ok(Json.toJson(pojo));
    }


    /** Envoie du Rating à la  Monetique - Message synchrone**/
    public static Result sendRating() throws UnirestException {
        Service service = Service.getInstances();
        JsonNode json = request().body().asJson();
        RatingPojo pojo = Json.fromJson(json, RatingPojo.class);
        Unirest.post(service.getServiceHttpURL(ServiceName.MONETARY_SYSTEM) + "/CRM/RATING")
                .header("Content-type", "application/json")
                .body(Json.toJson(pojo))
                .asJson();
        return ok();
    }

    /** Envoie du Risque à la Monetique - Message synchrone **/

    public static Result sendRisk() throws UnirestException {
        Service service = Service.getInstances();
        JsonNode json = request().body().asJson();
        RiskPojo pojo = Json.fromJson(json, RiskPojo.class);
        Unirest.post(service.getServiceHttpURL(ServiceName.MONETARY_SYSTEM) + "/CRM/RISK")
                .header("Content-type", "application/json")
                .body(Json.toJson(pojo))
                .asJson();

        return ok();
    }



}
