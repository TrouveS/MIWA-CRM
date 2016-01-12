package controllers.utils.pojo.AsyncMessagePojo.TicketPojo;

import controllers.clientManagement.ClientList;
import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Article;
import play.Logger;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class TicketPojo extends AsyncMessagePojo {

    private String client_id;
    private String ticket_id;
    private String magasin_id;
    private String ticket_date;
    private String idFidelite;
    private String total;
    private List<Article> article;

    public TicketPojo(){};

    @Override
    public void action()
    {
        TicketPojo ticket =  new TicketPojo();

        ticket.client_id = this.client_id;
        ticket.ticket_id = this.ticket_id;
        ticket.magasin_id = this.magasin_id;
        ticket.ticket_date = this.ticket_date;
        ticket.idFidelite = this.idFidelite;
        ticket.total = this.total;
        ticket.article = this.article;

        try {
            AsyncMessageProducer bi_ticket = new AsyncMessageProducer("CRM_ticket_caisse");
            bi_ticket.sendMessage(ticket);
            Logger.info("client message in queue {}", "CRM_ticket_caisse");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
