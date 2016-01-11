import controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo.ClientMessagePojo;
import controllers.utils.sender.AsyncMessageConsumer;
import org.json.JSONObject;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import controllers.utils.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application application) {
        if (application.isDev())
            Logger.info("start in dev mode");
        //TODO on start action
        subscribeQueue();
        super.onStart(application);
        JSONObject json = new JSONObject();
        json.put("nom","Flantier");
        json.put("prenom","Noelle");
        json.put("client_id_local","142");
        json.put("magasin_id","1");
        json.put("date_de_naissance", "20/08/1923");
        json.put("sexe", "F");
        json.put("email", "noel@flantier.fr");
        json.put("idRue", "rue du bois fleuri");
        json.put("idVille", "Reims");
        json.put("idCodePostal","51100");

        JSONObject json2 = new JSONObject();
        json2.put("nom","Flaner");
        json2.put("prenom","Noel");
        json2.put("client_id_local","142");
        json2.put("magasin_id","1");
        json2.put("date_de_naissance", "20/08/1923");
        json2.put("sexe", "F");
        json2.put("email", "noel@flaner.fr");
        json2.put("idRue", "rue du bois fleuri");
        json2.put("idVille", "Reims");
        json2.put("idCodePostal","51100");

        new ClientMessagePojo().action(json);
        new ClientMessagePojo().action(json2);

    }

    private void subscribeQueue()
    {
        try {
            AsyncMessageConsumer client = new AsyncMessageConsumer("INCIDENT_PAIEMENT");
            Thread clientThread = new Thread(client);
            clientThread.start();
            Logger.info("client message in queue {}", "INCIDENT_PAIEMENT");
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}
