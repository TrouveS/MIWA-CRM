package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

/**
 * Created by LuxiaMars on 14/01/2016.
 */
public class ReponseCartePojo {

    private long idfidelite;
    private int valeur_credit;

    public ReponseCartePojo() {
    }

    public ReponseCartePojo(long idfidelite, int valeur_credit) {
        this.idfidelite = idfidelite;
        this.valeur_credit = valeur_credit;
    }

    public long getIdfidelite() {
        return idfidelite;
    }

    public void setIdfidelite(long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public int getValeur_credit() {
        return valeur_credit;
    }

    public void setValeur_credit(int valeur_credit) {
        this.valeur_credit = valeur_credit;
    }
}
