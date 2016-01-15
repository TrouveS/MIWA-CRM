package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class RiskPojo extends AsyncMessagePojo {
    private long idfidelite;
    private int risque;

    public RiskPojo() {
    }

    public long getIdfidelite() {
        return idfidelite;
    }

    public void setIdfidelite(long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public int getRisque() {
        return risque;
    }

    public void setRisque(int risque) {
        this.risque = risque;
    }

    public void action(){
        }
    }