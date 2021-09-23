package jp.co.jeus.jeus.echo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("echo")
public class JavaEE8Resource {

    @GET
    public Response ping() {
        String env = System.getenv().get("hostname");
        return Response
                .ok(env)
                .build();
    }
}
