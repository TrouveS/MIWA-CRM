package controllers.utils.pojo.SyncMessagePojo.Monetarysystem;

import controllers.utils.pojo.AsyncMessagePojo.AsyncMessagePojo;

/**
 * Created by AmdouniNajla on 12/01/2016.
 */
public class RatingPojo extends AsyncMessagePojo {
    private long idfidelite;
    private  int rating;

    public RatingPojo() {
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

    public void action(){
    }
}

