package tech.donau.course;

import tech.donau.course.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {


    @Inject
    private GreetingService greetingService;

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return greetingService.sayHello(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.sayHello();
    }

//    public final String TOKEN = "dev";

//    @POST
//    @Path("/key")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String addHello(@HeaderParam("token") String header, @QueryParam("token") String query, String body) {
//        final String token = header != null ? header : query;
//        if (!TOKEN.equals(token)) {
//            throw new RuntimeException("Unauthorized");
//        }
//        return "{\"key\": \"" + token + "\"}";
//    }
}