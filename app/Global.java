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
