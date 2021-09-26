package jp.co.jeus.jeus.echo.resources;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
        String env = System.getenv("HOSTNAME");
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            if (env == null) {
                env = System.getenv().toString() + System.lineSeparator();
            } else {
                env += " | ";
            }
            env += addr.getHostAddress();
        } catch (UnknownHostException ex) {
            env = ex.getMessage();
        }
        return Response
                .ok(env)
                .build();
    }
}
