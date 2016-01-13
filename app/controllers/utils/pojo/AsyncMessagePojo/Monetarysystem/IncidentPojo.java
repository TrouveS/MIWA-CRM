package controllers.utils.pojo.AsyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageConsumer;
import model.Clients;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class IncidentPojo extends AsyncMessagePojo {
    private Long idFidelite;
    private int valeur_incident;
    private String erreur;

    public IncidentPojo() {
    }

    public void action(){
        Clients client;
        client = Clients.find.where().eq("idFidelite", idFidelite).findUnique();
        Integer valeur_incident_actuelle = 0;

        if(client != null)
        {
            valeur_incident_actuelle = (client.getCredit() * client.getNbIncidents()) + valeur_incident_actuelle;
            client.setCredit(valeur_incident_actuelle/(client.getNbIncidents()));
            client.setRating((1/client.getCredit())*100);
            client.save();
        }
    }
}
