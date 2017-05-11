package results;

import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.results.Result;

public class Unauthorized extends Result {

    public void apply(Request request, Response response) {
        response.status = Http.StatusCode.UNAUTHORIZED;
        response.setHeader("WWW-Authenticate", "INCRA-Basic");
    }	

}
