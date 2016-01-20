package controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.ServiceName;
import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.CartePojo;
import static play.data.Form.form;

import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.RatingPojo;
import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.ReponseCartePojo;
import controllers.utils.pojo.SyncMessagePojo.Monetarysystem.RiskPojo;
import model.Client;
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class RatingController extends Controller{

    /** Carte de la société venant de la Monetique  - Message synchrone**/
    public static Result getCarte(Long idClient, String typeDemande) throws UnirestException {

        Client client = Client.find.where().eq("clientId", idClient).findUnique();

        Logger.info("TEST DE LID: Demande de creation carte [" + "\n"
                + "Client : " + idClient);

        if (client != null)
        {

            Service service = Service.getInstances();
            CartePojo pojo = new CartePojo();
            pojo.setIdfidelite(client.getClientId());
            pojo.setRIB(client.getRib());
            pojo.setTypedemande(typeDemande);

            Logger.info("CRMC: Demande de creation carte [" + "\n"
                    + "Client : " + client.getClientId() + "\n"
                    + "Type de demande : " + typeDemande + "\n"
                    + "RIB : " + client.getRib() + "]\n");

            client.update();
            HttpResponse<com.mashape.unirest.http.JsonNode> jsonResponse = Unirest.post(service.getServiceHttpURL(ServiceName.MONETARY_SYSTEM) + "/CRM/CARTE")
                    .header("Content-type", "application/json")
                    .header("accept", "application/json")
                    .body(Json.toJson(pojo).toString())
                    .asJson();

            ReponseCartePojo reponse = Json.fromJson(Json.parse(jsonResponse.getRawBody()), ReponseCartePojo.class);
            client.setCredit(reponse.getValeur_credit());
            client.update();

            return ok();
        }
        else
            return badRequest();

    }


    /** Envoie du Rating à la  Monetique - Message synchrone**/
    public static Result sendRating(Long idFidelite) {
        Client client = Client.find.where().eq("clientId", idFidelite).findUnique();

        Logger.info(" CRMController : Demande de rating [" + "\n" +
                "Client_recu: " + idFidelite + "\n" +
                "Client : " + client.getClientId() + "\n" +
                "Rating : " + client.getRating() + "\n]");

        if (client != null) {
            RatingPojo pojo = new RatingPojo();
            pojo.setIdfidelite(client.getClientId());
            pojo.setRating(client.getRating());
            return ok(Json.toJson(pojo));
        }
        else
            return badRequest();

    }

    /** Envoie du Risque à la Monetique - Message synchrone **/

    public static Result sendRisk(Long idFidelite) {
        Client client = Client.find.where().eq("clientId", idFidelite).findUnique();

        if (client != null) {
            RiskPojo pojo = new RiskPojo();
            pojo.setIdfidelite(client.getClientId());
            pojo.setRisque(client.getRating());
            return ok(Json.toJson(pojo));
        }
        else
            return badRequest();

    }



}
