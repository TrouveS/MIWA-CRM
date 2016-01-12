package controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo;

import controllers.clientManagement.ClientList;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageConsumer;
import controllers.utils.sender.AsyncMessageProducer;
import model.Clients;
import org.json.JSONObject;
import play.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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

    public ClientMessagePojo(){};

    @Override
    public void action()
    {
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

        newClient.save();
        cl.addToClientList(client);

        try {
            AsyncMessageProducer crm_client_fidelise = new AsyncMessageProducer("CRM_to_BACKOFFICE_client");
            crm_client_fidelise.sendMessage(client);
            Logger.info("client message in queue {}", "CRM_to_BACKOFFICE_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        /** PrettyPrint a enlever **/

        System.out.println(newClient.getNom());
        System.out.println(newClient.getPrenom());
        System.out.println(newClient.getEmail());
        System.out.println(newClient.getDate());
        System.out.println(newClient.getSexe());
        System.out.println(newClient.getMagasin());
        System.out.println(newClient.getIdRue());
        System.out.println(newClient.getIdVille());
        System.out.println(newClient.getIdCodePostal());
        System.out.println("-----------------------");
        System.out.println(newClient.getIdFidelite());
        System.out.println(newClient.getUserId());
    }

}
