package tech.donau;

import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class GreetingResource {

    // Use type = blocking if large calculations that aren't async
    // Uses the method name for the endpoint, unless you specify a path in the Route
    @Route(methods = HttpMethod.GET)
    public void hello(RoutingContext rc) {
        rc.response().end("hello");
    }

    @Route(path = "/test/hello", methods = HttpMethod.GET)
    public void testHello (RoutingContext rc) {
        rc.response().end("hello");
    }

    public void init (@Observes Router router) {
        router.get("/book").handler (rc -> {
            rc.response().end("Book1");
        });
    }
}