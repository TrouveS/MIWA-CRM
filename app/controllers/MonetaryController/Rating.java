package controllers.MonetaryController;

import controllers.utils.sender.AsyncMessageConsumer;

import play.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class Rating {
    public static void getIncidentPaiement() {
        try {
            AsyncMessageConsumer client = new AsyncMessageConsumer("INCIDENT_PAIEMENT");
            Thread clientThread = new Thread(client);
            clientThread.start();
            Logger.info("client message in queue {}", "INCIDENT_PAIEMENT");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void getCarte() {
        try {
            AsyncMessageConsumer carte = new AsyncMessageConsumer("CARTE");
            Thread carteThread = new Thread(carte);
            carteThread.start();
            Logger.info("client message in queue {}", "CARTE");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
