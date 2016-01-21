package controllers;

import controllers.utils.pojo.AsyncMessagePojo.ClientPojo.ClientFideliseListPojo;
import controllers.utils.pojo.AsyncMessagePojo.ClientPojo.ClientFidelisePojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Client;
import model.Magasin;
import play.Logger;
import play.mvc.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static play.mvc.Results.ok;

/**
 * Created by LuxiaMars on 11/01/2016.
 */
public class ClientController {

    public static Result sendClientList() {
        Logger.info("Call back de la clock");
        List<ClientFidelisePojo> clientFidelisePojoList = new ArrayList<>();
        for (Client client : Client.find.all())
            clientFidelisePojoList.add(ClientFidelisePojo.loadFromModel(client));

        ClientFideliseListPojo clientFideliseListPojo = new ClientFideliseListPojo(clientFidelisePojoList);

        try {
            AsyncMessageProducer crm_client_list = new AsyncMessageProducer("CRM_clientList");
            crm_client_list.sendMessage(clientFideliseListPojo);
            Logger.info("client message in queue {}", "CRM_clientList");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

        List<Magasin> magasins;
        //Todo select list magasin
        for (Magasin magasin : Magasin.find.all()) {
            List<Client> list_client = Client.find.where().eq("magasin_id", magasin.getId_magasin()).findList();
            List<ClientFidelisePojo> clientFidelisePojoParisList = new ArrayList<>();
            for (Client client : list_client)
                clientFidelisePojoParisList.add(ClientFidelisePojo.loadFromModel(client));

            ClientFideliseListPojo clientFideliseListParisPojo = new ClientFideliseListPojo(clientFidelisePojoParisList);

            try {
                AsyncMessageProducer crm_client_list = new AsyncMessageProducer("CRM_clientList_" + magasin.getId_magasin());
                crm_client_list.sendMessage(clientFideliseListParisPojo);
                Logger.info("client message in queue {}", "CRM_client_" + magasin.getId_magasin());

            } catch (IOException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        return ok();
    }
}
