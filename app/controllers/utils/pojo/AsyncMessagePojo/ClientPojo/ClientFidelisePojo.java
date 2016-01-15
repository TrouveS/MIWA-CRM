package controllers.utils.pojo.AsyncMessagePojo.ClientPojo;

import com.mashape.unirest.http.exceptions.UnirestException;
import model.Client;

import java.util.Date;

/**
 * Created by Calu on 15/01/2016.
 */
public class ClientFidelisePojo extends ClientPojo {

    private Long idFidelite;

    public ClientFidelisePojo(String nom, String prenom, String email, String sexe, Date date_de_naissance, Long client_id_local, String magasin_id, String idRue, String idVille, String idCodePostal, Long idFidelite) {
        super(nom, prenom, email, sexe, date_de_naissance, client_id_local, magasin_id, idRue, idVille, idCodePostal);
        this.idFidelite = idFidelite;
    }

    public static ClientFidelisePojo loadFromModel(Client client){
        return new ClientFidelisePojo(client.getNom(), client.getPrenom(), client.getEmail(), client.getSexe(), client.getDate_naissance(), client.getClient_id_local(), client.getMagasinId(), client.getIdRue(), client.getIdVille(), client.getIdCodePostal(), client.getClientId());
    }

    public ClientFidelisePojo() {
        super();
    }

    public Long getIdFidelite() {
        return idFidelite;
    }

    public void setIdFidelite(Long idFidelite) {
        this.idFidelite = idFidelite;
    }

    @Override
    public void action() throws UnirestException {
        super.action();
    }
}
