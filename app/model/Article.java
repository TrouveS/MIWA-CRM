package model;

/**
 * Created by LuxiaMars on 12/01/2016.
 */
public class Article {

    private String article_id;
    private Integer price;
    private Integer quantity;

    public Article(String article_id, Integer price, Integer quantity) {
        this.article_id = article_id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
