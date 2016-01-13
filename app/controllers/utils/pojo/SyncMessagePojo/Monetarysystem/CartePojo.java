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

    public CartePojo() {
    }

    public Long getIdfidelite() {
        return idfidelite;
    }

    public void setIdfidelite(Long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public Long getRIB() {
        return RIB;
    }

    public void setRIB(Long RIB) {
        this.RIB = RIB;
    }

    public String getTypedemande() {
        return Typedemande;
    }

    public void setTypedemande(String typedemande) {
        Typedemande = typedemande;
    }

    public void action(){

    }

}
