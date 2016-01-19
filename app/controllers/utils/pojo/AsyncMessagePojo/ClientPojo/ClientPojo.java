package controllers.utils.pojo.AsyncMessagePojo.ClientPojo;

import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Client;
import play.Logger;
import play.data.format.Formats;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * Created by LuxiaMars on 11/01/2016.
 */

public class ClientPojo extends AsyncMessagePojo {

    public String email;
    private String nom;
    private String prenom;
    private String sexe;
    @Formats.DateTime(pattern = "HH:mm dd/MM/yyy")
    private Date date_de_naissance;
    private Long client_id_local;
    private String magasin_id;
    private String idRue;
    private String idVille;
    private String idCodePostal;

    public ClientPojo() {
    }

    public ClientPojo(String nom, String prenom, String email, String sexe, Date date_de_naissance, Long client_id_local, String magasin_id, String idRue, String idVille, String idCodePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.date_de_naissance = date_de_naissance;
        this.client_id_local = client_id_local;
        this.magasin_id = magasin_id;
        this.idRue = idRue;
        this.idVille = idVille;
        this.idCodePostal = idCodePostal;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getMagasin_id() {
        return magasin_id;
    }

    public void setMagasin_id(String magasin_id) {
        this.magasin_id = magasin_id;
    }

    public String getIdRue() {
        return idRue;
    }

    public void setIdRue(String idRue) {
        this.idRue = idRue;
    }

    public String getIdVille() {
        return idVille;
    }

    public void setIdVille(String idVille) {
        this.idVille = idVille;
    }

    public String getIdCodePostal() {
        return idCodePostal;
    }

    public void setIdCodePostal(String idCodePostal) {
        this.idCodePostal = idCodePostal;
    }

    public Long getClient_id_local() {
        return client_id_local;
    }

    public void setClient_id_local(Long client_id_local) {
        this.client_id_local = client_id_local;
    }

    @Override
    public void action() throws UnirestException {

        System.out.println("Reception d'une demande de creation d'un nouveau client");

        Client client;
        if ((client = Client.find.where().eq("email", this.email).findUnique()) == null) {
            client = new Client(this.email, this.nom, this.prenom, this.sexe, this.date_de_naissance, this.client_id_local, this.idRue, this.idVille, this.idCodePostal, this.magasin_id);
            client.save();
        }

        System.out.println("Nouveau client cree : " + client.getClientId());

        try {
            AsyncMessageProducer crm_client_fidelise = new AsyncMessageProducer("CRM_client");
            crm_client_fidelise.sendMessage(ClientFidelisePojo.loadFromModel(client));
            Logger.info("client message in queue {}", "CRM_client");
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
