import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.ServiceName;
import controllers.utils.pojo.AsyncMessagePojo.ClientPojo.ClientPojo;
import controllers.utils.pojo.AsyncMessagePojo.Monetarysystem.IncidentPojo;
import controllers.utils.pojo.AsyncMessagePojo.TicketPojo.TicketPojo;
import controllers.utils.pojo.SyncMessagePojo.ClockPojo;
import controllers.utils.sender.AsyncMessageConsumer;
import controllers.utils.sender.SyncMessageSender;
import model.Client;
import play.Application;
import play.GlobalSettings;
import play.Logger;

import java.io.IOException;
import java.util.Date;
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
        if (Client.find.all().size() == 0)
            createClients();
        super.onStart(application);

    }

    private void addCallback() {
        try {
            SyncMessageSender.addCallbackOnMainService(" 0 0 0 * * *", "/BACKOFFICE/SENDCLIENTS", "newDay", ServiceName.CRM, ClockPojo.RequestType.POST);
            SyncMessageSender.addCallbackOnMainService(" 0 0 0 * * *", "/BACKOFFICE/PROMOTION", "newDay", ServiceName.CRM, ClockPojo.RequestType.POST);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private void subscribeQueue() {
        /** Information nouveau client venant du BackOffice **/
        try {
            AsyncMessageConsumer crm_client = new AsyncMessageConsumer("BO_client", ClientPojo.class);
            Thread clientThread = new Thread(crm_client);
            clientThread.start();
            Logger.info("client message in queue {}", "BO_client");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        /** Ticket venant du BackOffice **/
        try {
            AsyncMessageConsumer backoffice_ticket = new AsyncMessageConsumer("BO_ticketCaisse", TicketPojo.class);
            Thread clientThread = new Thread(backoffice_ticket);
            clientThread.start();
            Logger.info("client message in queue {}", "BO_ticketCaisse");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        /** Ticket venant du ECommerce **/
        try {
            AsyncMessageConsumer ecommerce_ticket = new AsyncMessageConsumer("ECOMMERCE_ticketCaisse", TicketPojo.class);
            Thread clientThread = new Thread(ecommerce_ticket);
            clientThread.start();
            Logger.info("client message in queue {}", "ECOMMERCE_ticketCaisse");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

        /** Incident paiement venant de la Monetique**/
        try {
            AsyncMessageConsumer incident_paiement = new AsyncMessageConsumer("MONETARY_incidentPaiement", IncidentPojo.class);
            Thread incidentThread = new Thread(incident_paiement);
            incidentThread.start();
            Logger.info("client message in queue {}", "MONETARY_incidentPaiement");

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
        Client client1 = new Client();
        client1.setNom("Machiavelli");
        client1.setPrenom("Niccolo");
        client1.setEmail("n.machiavel@gmail.it");
        client1.setSexe("H");
        client1.setDate_naissance(new Date());
        client1.setIdRue("Via il Principe");
        client1.setIdVille("Firenze");
        client1.setIdCodePostal("FI234");
        client1.setMagasinId("paris");
        client1.setClient_id_local(100L);
        client1.setNbIncidents(0);
        client1.setCredit(500);
        client1.save();
        client1.save();

        Client client2 = new Client();
        client2.setNom("Alighieri");
        client2.setPrenom("Dante");
        client2.setEmail("d.alighieri@gmail.it");
        client2.setSexe("H");
        client2.setDate_naissance(new Date());
        client2.setIdRue("Via Inferno");
        client2.setIdVille("Firenze");
        client2.setIdCodePostal("FI232");
        client2.setMagasinId("paris");
        client2.setClient_id_local(100L);
        client2.setNbIncidents(0);
        client2.setCredit(500);
        client2.save();
        client2.save();

        Client client3 = new Client();
        client3.setNom("Borgia");
        client3.setPrenom("Cesare");
        client3.setEmail("cesare.il.grande@gmail.it");
        client3.setSexe("H");
        client3.setDate_naissance(new Date());
        client3.setIdRue("Via Imperatore");
        client3.setIdVille("Paris");
        client3.setIdCodePostal("RO590");
        client3.setMagasinId("paris");
        client3.setClient_id_local(100L);
        client3.setNbIncidents(0);
        client3.setCredit(1000);
        client3.save();
        client3.save();

        Client client4 = new Client();
        client4.setNom("Da Vinci");
        client4.setPrenom("Leonardo");
        client4.setEmail("maestro.leo@gmail.it");
        client4.setSexe("H");
        client4.setDate_naissance(new Date());
        client4.setIdRue("Via Mona Lisa");
        client4.setIdVille("Paris");
        client4.setIdCodePostal("VE442");
        client4.setMagasinId("paris");
        client4.setClient_id_local(100L);
        client4.setNbIncidents(0);
        client4.setCredit(530);
        client4.save();
        client4.save();

        Client client5 = new Client();
        client5.setNom("Buonarotti");
        client5.setPrenom("Michelangelo");
        client5.setEmail("magico.miche@gmail.it");
        client5.setSexe("H");
        client5.setDate_naissance(new Date());
        client5.setIdRue("Via Davide");
        client5.setIdVille("Paris");
        client5.setIdCodePostal("RO662");
        client5.setMagasinId("paris");
        client5.setClient_id_local(100L);
        client5.setNbIncidents(0);
        client5.setCredit(200);
        client5.save();
        client5.save();

    }
}