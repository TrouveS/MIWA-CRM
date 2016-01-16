package controllers;

import model.Client;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready.", (List<Client>) Client.find.all()));
    }

}
