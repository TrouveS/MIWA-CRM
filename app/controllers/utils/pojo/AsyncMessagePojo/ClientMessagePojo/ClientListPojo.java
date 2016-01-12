package controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo;

import controllers.clientManagement.ClientList;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;

import java.util.List;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class ClientListPojo extends AsyncMessagePojo {

    private ClientList cl = new ClientList();
    private List<ClientMessagePojo> clientsList = cl.getClientList();

    public void action() {
    }
}
