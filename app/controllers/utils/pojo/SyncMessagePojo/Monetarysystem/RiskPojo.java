package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Clients;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class RiskPojo extends AsyncMessagePojo {
    private long idfidelite;
    private int risque;
    RiskPojo riskPojo;

    public RiskPojo() {
    }

    public void action(){
        Clients client;
        client = Clients.find.where().eq("idFidelite", idfidelite).findUnique();

        if (client != null) {
            riskPojo.idfidelite = idfidelite;
            riskPojo.risque = client.getCredit();
        }
    }
}