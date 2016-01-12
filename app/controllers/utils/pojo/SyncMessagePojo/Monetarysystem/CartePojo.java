package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class CartePojo {
    private Long idfidelite;
    private String Typedemande;
    private Long RIB;

    public CartePojo() {
    }

    public CartePojo(Long idfidelite, String typedemande, Long RIB) {
        this.idfidelite = idfidelite;
        Typedemande = typedemande;
        this.RIB = RIB;
    }

    public Long getIdfidelite() {
        return idfidelite;
    }

    public void setIdfidelite(Long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public String getTypedemande() {
        return Typedemande;
    }

    public void setTypedemande(String typedemande) {
        Typedemande = typedemande;
    }

    public Long getRIB() {
        return RIB;
    }

    public void setRIB(Long RIB) {
        this.RIB = RIB;
    }
}
