package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Clients;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class CartePojo extends AsyncMessagePojo{
    private Long idfidelite;
    private String Typedemande;
    private Long RIB;
    CartePojo cartePojo;

    public CartePojo() {
    }

    public void action(){

        Clients client;
        client = Clients.find.where().eq("idFidelite", idfidelite).findUnique();

        if (client != null)
        {
            cartePojo.idfidelite = idfidelite;
            cartePojo.RIB = client.getRib();
            cartePojo.Typedemande = client.getTypedemande();
            client.setTypedemande(Typedemande);
            client.save();
        }
    }

}
