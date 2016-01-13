package controllers.MonetaryController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.ServiceName;
import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.CartePojo;


import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.RatingPojo;
import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.RiskPojo;
import model.Clients;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static play.mvc.Results.ok;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class Rating extends Controller{

    /** Carte de la société venant de la Monetique  - Message synchrone**/
    public static Result getCarte(Long idFidelite) {
        Clients client = Clients.find.where().eq("idFidelite", idFidelite).findUnique();

        if (client != null)
        {
            CartePojo pojo = new CartePojo();
            pojo.setIdfidelite(idFidelite);
            pojo.setRIB(client.getRib());
            pojo.setTypedemande(client.getTypedemande());
            return ok(Json.toJson(pojo));
        }
        else
            return badRequest();

    }


    /** Envoie du Rating à la  Monetique - Message synchrone**/
    public static Result sendRating(Long idFidelite) {
        Clients client = Clients.find.where().eq("idFidelite", idFidelite).findUnique();

        if (client != null) {
            RatingPojo pojo = new RatingPojo();
            pojo.setIdfidelite(client.getIdFidelite());
            pojo.setRating(client.getRating());
            return ok(Json.toJson(pojo));
        }
        else
            return badRequest();

    }

    /** Envoie du Risque à la Monetique - Message synchrone **/

    public static Result sendRisk(Long idFidelite) {
        Clients client = Clients.find.where().eq("idFidelite", idFidelite).findUnique();

        if (client != null) {
            RiskPojo pojo = new RiskPojo();
            pojo.setIdfidelite(client.getIdFidelite());
            pojo.setRisque(client.getRating());
            return ok(Json.toJson(pojo));
        }
        else
            return badRequest();

    }



}
