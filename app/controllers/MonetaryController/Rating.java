package controllers.MonetaryController;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.utils.Service;
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

        return ok();
    }


    /** Envoie du Rating à la  Monetique**/
    public static Result sendRating() {
        Service service = Service.getInstances();
        JsonNode json = request().body().asJson();
        RatingPojo pojo = Json.fromJson(json, RatingPojo.class);

        return ok();
    }

    /** Envoie du Risque à la Monetique**/

    public static Result sendRisk() {
        Service service = Service.getInstances();
        JsonNode json = request().body().asJson();
        RiskPojo pojo = Json.fromJson(json, RiskPojo.class);

        return ok();
    }



}
