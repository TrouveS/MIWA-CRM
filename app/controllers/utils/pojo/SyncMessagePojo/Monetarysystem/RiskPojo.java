package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class RiskPojo {
    private long idfidelite;
    private int risque;

    public RiskPojo() {
    }

    public RiskPojo(long idfidelite, int risque) {
        this.idfidelite = idfidelite;
        this.risque = risque;
    }

    public long getIdfidelite() {
        return idfidelite;
    }

    public int getRisque() {
        return risque;
    }

    public void setIdfidelite(long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public void setRisque(int risque) {
        this.risque = risque;
    }
}