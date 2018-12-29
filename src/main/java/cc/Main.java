package cc.project;

import cc.project.resources.REST;
import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * This class initialize the HTTP server.
 *
 * @author saulopez
 * @date 28th December, 2018
 */
public class Main {

    private static final int PORT = 8084;
    private static final String HOST = "http://localhost/";

    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri(HOST).port(PORT).build();
        ResourceConfig config = new ResourceConfig(REST.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
    }

}
