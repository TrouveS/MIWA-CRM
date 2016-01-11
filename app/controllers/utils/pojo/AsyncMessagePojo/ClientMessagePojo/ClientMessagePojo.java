package controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo;

import model.Clients;
import org.json.JSONObject;
import java.io.Serializable;


public class ClientMessagePojo implements Serializable{

    public void action(JSONObject client)
    {
        Clients new_client = new Clients();
        JSONObject jsonClient = new JSONObject();

        /** Creation du client **/

        new_client.setNom(client.getString("nom"));
        new_client.setPrenom(client.getString("prenom"));
        new_client.setEmail(client.getString("email"));
        new_client.setMagasin(client.getString("magasin_id"));
        new_client.setDate(client.getString("date_de_naissance"));
        new_client.setSexe(client.getString("sexe"));
        new_client.setIdRue(client.getString("idRue"));
        new_client.setIdVille(client.getString("idVille"));
        new_client.setIdCodePostal(client.getString("idCodePostal"));


        /** Creation du JSON a renvoye **/

        jsonClient.put("nom", new_client.getNom());
        jsonClient.put("prenom", new_client.getPrenom());
        jsonClient.put("client_id_local", client.getString("client_id_local"));
        jsonClient.put("magasin_id", new_client.getMagasin());
        jsonClient.put("idFidelite", new_client.getIdFidelite());
        jsonClient.put("date_de_naissance", new_client.getDate());
        jsonClient.put("sexe", new_client.getSexe());
        jsonClient.put("email", new_client.getEmail());
        jsonClient.put("idRue", new_client.getIdRue());
        jsonClient.put("idVille", new_client.getIdVille());
        jsonClient.put("idCodePostal", new_client.getIdCodePostal());

        new_client.save();

        /** Pretryprint a enlever **/

        System.out.println(new_client.getNom());
        System.out.println(new_client.getPrenom());
        System.out.println(new_client.getEmail());
        System.out.println(new_client.getDate());
        System.out.println(new_client.getSexe());
        System.out.println(new_client.getMagasin());
        System.out.println(new_client.getIdRue());
        System.out.println(new_client.getIdVille());
        System.out.println(new_client.getIdCodePostal());
        System.out.println("-----------------------");
        System.out.println(new_client.getIdFidelite());
        System.out.println(new_client.getUserId());
    }
}
