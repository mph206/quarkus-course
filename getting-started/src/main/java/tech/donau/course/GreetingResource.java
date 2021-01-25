package tech.donau.course;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    public final String TOKEN = "dev";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("id") String id) {
        return "hello " + id;
    }

    @POST
    @Path("/key")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addHello(@HeaderParam("token") String header, @QueryParam("token") String query, String body) {
        final String token = header != null ? header : query;
        if (!TOKEN.equals(token)) {
            throw new RuntimeException("Unauthorized");
        }
        return "{\"key\": \"" + token + "\"}";
    }
}