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

    public Long getIdfidelite() {
        return idfidelite;
    }

    public void setIdfidelite(Long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public int getValeur_incident() {
        return valeur_incident;
    }

    public void setValeur_incident(int valeur_incident) {
        this.valeur_incident = valeur_incident;
    }

    public String getErreur() {
        return erreur;
    }

    public void setErreur(String erreur) {
        this.erreur = erreur;
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
