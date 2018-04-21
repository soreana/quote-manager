package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PoemController extends Controller {
    private static Logger log = LogManager.getLogger(PoemController.class);

    public Result getPoems(){
        return ok("One day I gone a fly away");
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result newPoem(){
        JsonNode newTags = request().body().asJson().get("payload");

        log.info(newTags);

        return ok("saved");
    }
}
