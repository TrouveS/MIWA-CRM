import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.pojo.AsyncMessagePojo.ClientMessagePojo.ClientMessagePojo;
import controllers.utils.pojo.AsyncMessagePojo.Monetarysystem.IncidentPojo;
import controllers.utils.pojo.AsyncMessagePojo.TicketPojo.TicketPojo;
import controllers.utils.pojo.SyncMessagePojo.ClockPojo;
import controllers.utils.sender.AsyncMessageConsumer;
import controllers.utils.sender.SyncMessageSender;
import model.Clients;
import play.Application;
import play.GlobalSettings;
import play.Logger;

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
        createClients();
        super.onStart(application);

    }

    private void addCallback() {
        try {
            SyncMessageSender.addCallbackOnMainService(" 0 0 0 * * *", "/BACKOFFICE/SENDCLIENTS", "newDay", Service.SERVICE_NAME, ClockPojo.RequestType.GET);
            SyncMessageSender.addCallbackOnMainService(" 0 0 0 * * *", "/BACKOFFICE/PROMOTION", "newDay", Service.SERVICE_NAME, ClockPojo.RequestType.GET);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private void subscribeQueue() {
        /** Information nouveau client venant du BackOffice **/
        try {
            AsyncMessageConsumer crm_client = new AsyncMessageConsumer("CRM_client", ClientMessagePojo.class);
            Thread clientThread = new Thread(crm_client);
            clientThread.start();
            Logger.info("client message in queue {}", "CRM_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        /** Ticket venant du BackOffice **/
        try {
            AsyncMessageConsumer backoffice_ticket = new AsyncMessageConsumer("ticket_caisse", TicketPojo.class);
            Thread clientThread = new Thread(backoffice_ticket);
            clientThread.start();
            Logger.info("client message in queue {}", "ticket_caisse");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        /** Ticket venant du ECommerce **/
        try {
            AsyncMessageConsumer ecommerce_ticket = new AsyncMessageConsumer("ticket_caisse", TicketPojo.class);
            Thread clientThread = new Thread(ecommerce_ticket);
            clientThread.start();
            Logger.info("client message in queue {}", "CRM_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

        /** Incident paiement venant de la Monetique**/
        try {
            AsyncMessageConsumer incident_paiement = new AsyncMessageConsumer("INCIDENT_PAIEMENT", IncidentPojo.class);
            Thread incidentThread = new Thread(incident_paiement);
            incidentThread.start();
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

    private void createClients() {
        Clients client1 = new Clients();
        client1.setNom("Machiavelli");
        client1.setPrenom("Niccolo");
        client1.setEmail("n.machiavel@gmail.it");
        client1.setSexe("H");
        client1.setDate("23/03/1500");
        client1.setIdRue("Via il Principe");
        client1.setIdVille("Firenze");
        client1.setIdCodePostal("FI234");
        client1.setMagasin("SPESA2000");
        client1.setNbIncidents(0);
        client1.setCredit(500);
        client1.save();
        client1.setIdFidelite(1450L);
        client1.save();

        Clients client2 = new Clients();
        client2.setNom("Alighieri");
        client2.setPrenom("Dante");
        client2.setEmail("d.alighieri@gmail.it");
        client2.setSexe("H");
        client2.setDate("23/03/1410");
        client2.setIdRue("Via Inferno");
        client2.setIdVille("Firenze");
        client2.setIdCodePostal("FI232");
        client2.setMagasin("SPESA2000");
        client2.setNbIncidents(0);
        client2.setCredit(500);
        client2.save();
        client2.setIdFidelite(1410L);
        client2.save();

        Clients client3 = new Clients();
        client3.setNom("Borgia");
        client3.setPrenom("Cesare");
        client3.setEmail("cesare.il.grande@gmail.it");
        client3.setSexe("H");
        client3.setDate("23/12/1540");
        client3.setIdRue("Via Imperatore");
        client3.setIdVille("Roma");
        client3.setIdCodePostal("RO590");
        client3.setMagasin("SPESA2000");
        client3.setNbIncidents(0);
        client3.setCredit(1000);
        client3.save();
        client3.setIdFidelite(1540L);
        client3.save();

        Clients client4 = new Clients();
        client4.setNom("Da Vinci");
        client4.setPrenom("Leonardo");
        client4.setEmail("maestro.leo@gmail.it");
        client4.setSexe("H");
        client4.setDate("14/03/1510");
        client4.setIdRue("Via Mona Lisa");
        client4.setIdVille("Venezia");
        client4.setIdCodePostal("VE442");
        client4.setMagasin("SPESA2000");
        client4.setNbIncidents(0);
        client4.setCredit(530);
        client4.save();
        client4.setIdFidelite(1551L);
        client4.save();

        Clients client5 = new Clients();
        client5.setNom("Buonarotti");
        client5.setPrenom("Michelangelo");
        client5.setEmail("magico.miche@gmail.it");
        client5.setSexe("H");
        client5.setDate("17/03/1490");
        client5.setIdRue("Via Davide");
        client5.setIdVille("Roma");
        client5.setIdCodePostal("RO662");
        client5.setMagasin("SPESA2000");
        client5.setNbIncidents(0);
        client5.setCredit(200);
        client5.save();
        client5.setIdFidelite(1490L);
        client5.save();
    }
}