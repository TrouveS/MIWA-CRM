package controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo;

import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.MonetaryController.Rating;
import controllers.clientManagement.ClientList;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Clients;
import play.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by LuxiaMars on 11/01/2016.
 */

public class ClientMessagePojo extends AsyncMessagePojo{

    private String nom;
    private String prenom;
    public String email;
    private String sexe;
    private String client_id_local;
    private String date_de_naissance;
    private String magasin_id;
    private Long idFidelite;
    private String idRue;
    private String idVille;
    private String idCodePostal;
    private String rib;

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public ClientMessagePojo(){};

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

    public String getClient_id_local() {
        return client_id_local;
    }

    public void setClient_id_local(String client_id_local) {
        this.client_id_local = client_id_local;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getMagasin_id() {
        return magasin_id;
    }

    public void setMagasin_id(String magasin_id) {
        this.magasin_id = magasin_id;
    }

    public Long getIdFidelite() {
        return idFidelite;
    }

    public void setIdFidelite(Long idFidelite) {
        this.idFidelite = idFidelite;
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

    @Override
    public void action() throws UnirestException {
        Clients newClient = new Clients();
        ClientMessagePojo client = new ClientMessagePojo();
        ClientList cl = new ClientList();

        /** Si le mail est deja connu, ne pas ajouter le client et renvoyer sa fiche**/

        String emailClient;
        emailClient = this.email;

        Clients email = Clients.find.where().eq("email", emailClient).findUnique();

        if(email != null)
        {
            Clients existingClient = email;
            client.nom = existingClient.getNom();
            client.prenom = existingClient.getPrenom();
            client.client_id_local =  this.client_id_local;
            client.magasin_id = existingClient.getMagasin();
            client.date_de_naissance = existingClient.getDate();
            client.idFidelite =  existingClient.getIdFidelite();
            client.sexe = existingClient.getSexe();
            client.email = existingClient.getEmail();
            client.idRue = existingClient.getIdRue();
            client.idVille = existingClient.getIdCodePostal();
            client.idCodePostal = existingClient.getIdCodePostal();
            client.rib = existingClient.getRib();

            System.out.println("Client existant");
            existingClient.save();
            return;
        }

        /** Creation du client **/

        newClient.setNom(this.nom);
        newClient.setPrenom(this.prenom);
        newClient.setEmail(this.email);
        newClient.setMagasin(this.magasin_id);
        newClient.setDate(this.date_de_naissance);
        newClient.setSexe(this.sexe);
        newClient.setIdRue(this.idRue);
        newClient.setIdVille(this.idVille);
        newClient.setIdCodePostal(this.idCodePostal);
        newClient.setRib(this.rib);


        /** Creation du POJO a renvoye **/

        client.nom = newClient.getNom();
        client.prenom = newClient.getPrenom();
        client.client_id_local =  this.client_id_local;
        client.magasin_id = newClient.getMagasin();
        client.date_de_naissance = newClient.getDate();
        client.idFidelite =  newClient.getIdFidelite();
        client.sexe = newClient.getSexe();
        client.email = newClient.getEmail();
        client.idRue = newClient.getIdRue();
        client.idVille = newClient.getIdCodePostal();
        client.idCodePostal = newClient.getIdCodePostal();
        client.rib = newClient.getRib();

        newClient.save();
        cl.addToClientList(client);

        Rating.getCarte(newClient.getIdFidelite());

        try {
            AsyncMessageProducer crm_client_fidelise = new AsyncMessageProducer("CRM_client");
            crm_client_fidelise.sendMessage(client);
            Logger.info("client message in queue {}", "CRM_client");
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
