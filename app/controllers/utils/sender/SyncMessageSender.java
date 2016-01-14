package controllers.utils.sender;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.utils.Service;
import controllers.utils.ServiceName;
import controllers.utils.pojo.SyncMessagePojo.AppPojo;
import controllers.utils.pojo.SyncMessagePojo.ClockPojo;
import controllers.utils.pojo.SyncMessagePojo.SyncMessagePojo;
import play.Logger;
import play.libs.Json;

public class SyncMessageSender {

    public static HttpResponse<String> addServiceOnMainService(ServiceName serviceName) throws UnirestException {
        Service service = Service.getInstances();
        Logger.info("record service {}, on mainWebService", serviceName.toString());
        return Unirest.post(service.getServiceHttpURL(ServiceName.MAIN_WS) + Service.MAIN_WS_PATH_APP)
                .header("Content-type", "application/json")
                .body(Json.toJson(new AppPojo(serviceName.toString(), service.getServiceHttpURL(serviceName), Service.SERVICE_PORT.toString())).toString())
                .asString();
    }

    public static HttpResponse<String> addCallbackOnMainService(String cron, String pathCallBack, String body, ServiceName serviceName, ClockPojo.RequestType requestType) throws UnirestException {
        Service service = Service.getInstances();
        Logger.info("add callback {} on {}, each {}", requestType.toString(), pathCallBack, cron);
        return Unirest.post(service.getServiceHttpURL(ServiceName.MAIN_WS) + Service.MAIN_WS_PATH_CLOCK)
                .header("Content-type", "application/json")
                .body(Json.toJson(new ClockPojo(cron, pathCallBack, body, serviceName.toString(), requestType)).toString())
                .asString();
    }

    public static HttpResponse<String> sendMessagePostSync(SyncMessagePojo body,
                                                       ServiceName serviceName, String endpoint) throws UnirestException {
        Service service = Service.getInstances();
        Logger.info("Send message", body);
        return Unirest.post(service.getServiceHttpURL(serviceName) + endpoint)
                .header("Content-type", "application/json")
                .body(Json.toJson(body).toString())
                .asString();
    }
}
