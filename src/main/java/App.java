import static spark.Spark.*;
import spark.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;
import static spark.debug.DebugScreen.enableDebugScreen;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String [] args){
        String layout = "templates/layout.vtl";
        enableDebugScreen();

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        setPort(port);

        get("/", (request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
