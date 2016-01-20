package controllers.utils.pojo.AsyncMessagePojo.MagasinPojo;

/**
 * Created by Calu on 20/01/2016.
 */
public class MagasinPojo {

    private String id_magasin;
    private String nom_magasin;
    private String adresse_magasin;

    public MagasinPojo(String id_magasin, String nom_magasin, String adresse_magasin) {
        this.id_magasin = id_magasin;
        this.nom_magasin = nom_magasin;
        this.adresse_magasin = adresse_magasin;
    }

    public MagasinPojo() {
    }

    public String getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(String id_magasin) {
        this.id_magasin = id_magasin;
    }

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }

    public String getAdresse_magasin() {
        return adresse_magasin;
    }

    public void setAdresse_magasin(String adresse_magasin) {
        this.adresse_magasin = adresse_magasin;
    }
}
