package controllers.clientManagement;

import controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo.ClientMessagePojo;
import controllers.utils.sender.AsyncMessageProducer;
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
public class ClientList {

    private static List<ClientMessagePojo> clientList = new ArrayList<>();

    public ClientList() {
    }

    public List<ClientMessagePojo> getClientList() {
        return clientList;
    }

    private static void cleanClientList() {
        clientList.clear();
    }

    public void addToClientList(ClientMessagePojo client) {
        clientList.add(client);
    }

    public static Result sendModificationClient() {
        try {
            AsyncMessageProducer crm_client_list = new AsyncMessageProducer("CRM_to_BACKOFFICE_client");
            //crm_client_list.sendMessage(clientList);
            cleanClientList();
            Logger.info("client message in queue {}", "CRM_to_BACKOFFICE_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return ok();
    }
}
