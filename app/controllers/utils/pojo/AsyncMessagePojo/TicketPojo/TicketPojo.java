package controllers.utils.pojo.AsyncMessagePojo.TicketPojo;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;
import controllers.utils.sender.AsyncMessageProducer;
import model.Article;
import model.Clients;
import play.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class TicketPojo extends AsyncMessagePojo {

    private Long client_id;
    private String ticket_id;
    private String magasin_id;
    private String ticket_date;
    private Long idFidelite;
    private String date;
    private Float total;
    private List<Article> articles;

    public TicketPojo(){}

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public void action()
    {
        TicketPojo ticket =  new TicketPojo();
        Clients client = Clients.find.where().eq("idFidelite", idFidelite).findUnique();
        if(client != null) {
            client.setRating(client.getRating() + 1);
            client.save();
        }

        ticket.client_id = this.client_id;
        ticket.ticket_id = this.ticket_id;
        ticket.magasin_id = this.magasin_id;
        ticket.ticket_date = this.ticket_date;
        ticket.idFidelite = this.idFidelite;
        ticket.total = this.total;
        ticket.articles = this.articles;



        try {
            AsyncMessageProducer bi_ticket = new AsyncMessageProducer("CRM_ticket_caisse");
            bi_ticket.sendMessage(ticket);
            Logger.info("client message in queue {}", "CRM_ticket_caisse");

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
