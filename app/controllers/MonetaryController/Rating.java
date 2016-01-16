package controllers.MonetaryController;

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
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class Rating extends Controller{

    /** Carte de la société venant de la Monetique  - Message synchrone**/
    public static Result getCarte() throws UnirestException {

        DynamicForm requestData = form().bindFromRequest();
        Long idfidelite = Long.valueOf(requestData.get("idfidelite"));
        Client client = Client.find.where().eq("clientId", idfidelite).findUnique();

        if (client != null)
        {
            String typedemande = requestData.get("typedemande");

            Service service = Service.getInstances();
            CartePojo pojo = new CartePojo();
            pojo.setIdfidelite(idfidelite);
            pojo.setRIB(client.getRib());
            pojo.setTypedemande(typedemande);

            client.update();
            HttpResponse<com.mashape.unirest.http.JsonNode> jsonResponse = Unirest.post(service.getServiceHttpURL(ServiceName.MONETARY_SYSTEM) + "/MONETARYSYSTEM/RATING")
                    .header("Content-type", "application/json")
                    .header("accept", "application/json")
                    .body(Json.toJson(client).toString())
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
        Client client = Client.find.where().eq("idFidelite", idFidelite).findUnique();

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
        Client client = Client.find.where().eq("idFidelite", idFidelite).findUnique();

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
