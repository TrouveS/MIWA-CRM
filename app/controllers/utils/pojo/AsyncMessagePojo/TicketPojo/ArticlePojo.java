package controllers.utils.pojo.AsyncMessagePojo.TicketPojo;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class ArticlePojo {

    private Long article_id;
    private Float price;
    private Integer quantity;

    public ArticlePojo(Long article_id, Float price, Integer quantity) {
        this.article_id = article_id;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
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
