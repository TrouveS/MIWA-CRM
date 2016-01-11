package controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo;

import controllers.clientManagement.ClientList;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import model.Clients;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.List;

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
    private String magasin;

    public ClientMessagePojo(String nom, String prenom, String email, String sexe, String client_id_local,
                             String date_de_naissance, String magasin_id, Long idFidelite, String idRue, String idVille,
                             String idCodePostal, String magasin) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.client_id_local = client_id_local;
        this.date_de_naissance = date_de_naissance;
        this.magasin_id = magasin_id;
        this.idFidelite = idFidelite;
        this.idRue = idRue;
        this.idVille = idVille;
        this.idCodePostal = idCodePostal;
        this.magasin = magasin;
    }



    @Override
    public void action()
    {
        Clients newClient = new Clients();
        JSONObject jsonClient = new JSONObject();
        ClientList cl = new ClientList();

        /** Si le mail est deja connu, ne pas ajouter le client et renvoyer sa fiche**/

        String emailClient;
        emailClient = this.email;

        List<Clients> allEmail = Clients.find.where().eq("email", emailClient).findList();

        if(!allEmail.isEmpty())
        {
            Clients existingClient = allEmail.get(0);
            jsonClient.put("nom", existingClient.getNom());
            jsonClient.put("prenom", existingClient.getPrenom());
            jsonClient.put("client_id_local", this.client_id_local);
            jsonClient.put("magasin_id", existingClient.getMagasin());
            jsonClient.put("idFidelite", existingClient.getIdFidelite());
            jsonClient.put("date_de_naissance", existingClient.getDate());
            jsonClient.put("sexe", existingClient.getSexe());
            jsonClient.put("email", existingClient.getEmail());
            jsonClient.put("idRue", existingClient.getIdRue());
            jsonClient.put("idVille", existingClient.getIdVille());
            jsonClient.put("idCodePostal", existingClient.getIdCodePostal());

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


        /** Creation du JSON a renvoye **/

        jsonClient.put("nom", newClient.getNom());
        jsonClient.put("prenom", newClient.getPrenom());
        jsonClient.put("client_id_local", this.client_id_local);
        jsonClient.put("magasin_id", newClient.getMagasin());
        jsonClient.put("idFidelite", newClient.getIdFidelite());
        jsonClient.put("date_de_naissance", newClient.getDate());
        jsonClient.put("sexe", newClient.getSexe());
        jsonClient.put("email", newClient.getEmail());
        jsonClient.put("idRue", newClient.getIdRue());
        jsonClient.put("idVille", newClient.getIdVille());
        jsonClient.put("idCodePostal", newClient.getIdCodePostal());

        newClient.save();
        cl.addToClientList(jsonClient);

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
