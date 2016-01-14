package controllers.utils.pojo.AsyncMessagePojo;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.Serializable;

public abstract class AsyncMessagePojo implements Serializable {

    public abstract void action() throws UnirestException;
}
