package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class RatingPojo {
    private long idfidelite;
    private  int rating;

    public RatingPojo() {
    }

    public RatingPojo(long idfidelite, int rating) {
        this.idfidelite = idfidelite;
        this.rating = rating;
    }

    public long getIdfidelite() {
        return idfidelite;
    }

    public void setIdfidelite(long idfidelite) {
        this.idfidelite = idfidelite;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
