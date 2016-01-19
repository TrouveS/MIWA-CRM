package controllers;

import controllers.utils.pojo.AsyncMessagePojo.ClientPojo.ClientFidelisePojo;
import controllers.utils.pojo.AsyncMessagePojo.ClientPojo.ClientFideliseListPojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Client;
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
        for(Client client: Client.find.all())
            clientFidelisePojoList.add(ClientFidelisePojo.loadFromModel(client));

            ClientFideliseListPojo clientFideliseListPojo = new ClientFideliseListPojo(clientFidelisePojoList);

        try {
            AsyncMessageProducer crm_client_list = new AsyncMessageProducer("CRM_clientList");
            crm_client_list.sendMessage(clientFideliseListPojo);
            Logger.info("client message in queue {}", "CRM_clientList");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return ok();
    }
}
