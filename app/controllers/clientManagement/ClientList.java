package controllers.clientManagement;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuxiaMars on 11/01/2016.
 */
public class ClientList {

    private static List<JSONObject> clientList = new ArrayList<>();

    public ClientList(){}

    public List<JSONObject> getClientList(){
        return clientList;
    }

    public void cleanClientList(){
        clientList.clear();
    }

    public void addToClientList(JSONObject json){
        clientList.add(json);
    }
}
