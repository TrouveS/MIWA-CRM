package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Clients;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class CartePojo extends AsyncMessagePojo{
    private Long idfidelite;
    private String typedemande;
    private String rib;

    public CartePojo() {

    }

    public Long getIdfidelite() {
        return idfidelite;
    }

    public void setIdfidelite(Long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public String getRIB() {
        return rib;
    }

    public void setRIB(String rib) {
        this.rib = rib;
    }

    public String getTypedemande() {
        return typedemande;
    }

    public void setTypedemande(String typedemande) {
        this.typedemande = typedemande;
    }

    public void action(){

    }

}
