package controllers.utils.pojo.AsyncMessagePojo.Monetarysystem;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class IncidentPojo {
    private Long idFidelite;
    private int valeur_incident;
    private String erreur;

    public IncidentPojo(Long idFidelite, int valeur_incident, String erreur) {
        this.idFidelite = idFidelite;
        this.valeur_incident = valeur_incident;
        this.erreur = erreur;
    }

    public IncidentPojo() {
    }

    public Long getIdFidelite() {
        return idFidelite;
    }

    public void setIdFidelite(Long idFidelite) {
        this.idFidelite = idFidelite;
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
}
