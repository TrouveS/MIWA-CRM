package controllers.utils.pojo.AsyncMessagePojo.TicketPojo;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class ArticlePojo {

    private String id_article;
    private Float price;
    private Integer quantity;

    public ArticlePojo(String article_id, Float price, Integer quantity) {
        this.id_article = article_id;
        this.price = price;
        this.quantity = quantity;
    }

    public ArticlePojo() {
    }

    public String getId_article() {
        return id_article;
    }

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
