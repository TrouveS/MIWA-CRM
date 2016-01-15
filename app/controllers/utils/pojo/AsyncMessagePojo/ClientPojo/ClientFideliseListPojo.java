package controllers.utils.pojo.AsyncMessagePojo.ClientPojo;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;

import java.util.List;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class ClientFideliseListPojo extends AsyncMessagePojo {

    private List<ClientFidelisePojo> clientList;

    public ClientFideliseListPojo(List<ClientFidelisePojo> clientList) {
        this.clientList = clientList;
    }

    public ClientFideliseListPojo() {
    }

    public List<ClientFidelisePojo> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientFidelisePojo> clientList) {
        this.clientList = clientList;
    }

    public void action() {
    }
}
