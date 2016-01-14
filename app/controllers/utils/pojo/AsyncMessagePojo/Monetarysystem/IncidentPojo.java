package controllers.utils.pojo.AsyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageConsumer;
import model.Clients;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class IncidentPojo extends AsyncMessagePojo {
    private Long idfidelite;
    private int valeur_incident;
    private String erreur;

    public IncidentPojo() {
    }

    public void action(){
        Clients client;
        client = Clients.find.where().eq("idFidelite", idfidelite).findUnique();

        if(client != null)
        {
            client.setRating(client.getRating()-5);
            client.setCredit(client.getCredit() - valeur_incident);
            client.save();
        }

    }
}
