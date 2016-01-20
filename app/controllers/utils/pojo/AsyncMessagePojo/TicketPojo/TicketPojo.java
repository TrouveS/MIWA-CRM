package controllers.utils.pojo.AsyncMessagePojo.TicketPojo;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Client;
import play.Logger;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class TicketPojo extends AsyncMessagePojo {

    private Long client_id;
    private int ticket_id;
    private String magasin_id;
    private String ticket_date;
    private Long idFidelite;
    private Float total;
    private List<ArticlePojo> articles;

    public TicketPojo(){}

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getMagasin_id() {
        return magasin_id;
    }

    public void setMagasin_id(String magasin_id) {
        this.magasin_id = magasin_id;
    }

    public String getTicket_date() {
        return ticket_date;
    }

    public void setTicket_date(String ticket_date) {
        this.ticket_date = ticket_date;
    }

    public Long getIdFidelite() {
        return idFidelite;
    }

    public void setIdFidelite(Long idFidelite) {
        this.idFidelite = idFidelite;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<ArticlePojo> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlePojo> articles) {
        this.articles = articles;
    }

    @Override
    public void action()
    {
        System.out.println("reception d'un ticket de caisse");

        TicketPojo ticket =  new TicketPojo();
        Client client = Client.find.where().eq("client_id", idFidelite).findUnique();
        if(client != null) {
            System.out.println("Mise a jour du rating");
            System.out.println("Client id : " + client.getClientId());
            client.setRating(client.getRating() + 1);
            client.update();
        }

        ticket.client_id = this.client_id;
        ticket.ticket_id = this.ticket_id;
        ticket.magasin_id = this.magasin_id;
        ticket.ticket_date = this.ticket_date;
        ticket.idFidelite = this.idFidelite;
        ticket.total = this.total;
        ticket.articles = this.articles;

        try {
            System.out.println("Envoi du ticket de caisse a la BI");
            AsyncMessageProducer bi_ticket = new AsyncMessageProducer("CRM_ticketCaisse");
            bi_ticket.sendMessage(ticket);
            Logger.info("client message in queue {}", "CRM_ticketCaisse");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
