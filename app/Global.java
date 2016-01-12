import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo.ClientMessagePojo;
import controllers.utils.pojo.SyncMessagePojo.ClockPojo;
import controllers.utils.sender.AsyncMessageConsumer;
import controllers.utils.sender.SyncMessageSender;
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
        saveService();
        addCallback();
        subscribeQueue();
        super.onStart(application);

    }

    private void addCallback() {
        try {
            SyncMessageSender.addCallbackOnMainService(" 0 0 0 * * *", "/BACKOFFICE/SENDCLIENTS", "newDay", Service.SERVICE_NAME, ClockPojo.RequestType.GET);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private void subscribeQueue()
    {
        /** Information nouveau client venant du BackOffice **/
        try {
            AsyncMessageConsumer crm_client = new AsyncMessageConsumer("CRM_client");
            Thread clientThread = new Thread(crm_client);
            clientThread.start();
            Logger.info("client message in queue {}", "CRM_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        /** Incident paiement **/
        try {
            AsyncMessageConsumer client = new AsyncMessageConsumer("INCIDENT_PAIEMENT");
            Thread clientThread = new Thread(client);
            clientThread.start();
            Logger.info("client message in queue {}", "INCIDENT_PAIEMENT");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void saveService() {
        try {
            SyncMessageSender.addServiceOnMainService(Service.SERVICE_NAME);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
