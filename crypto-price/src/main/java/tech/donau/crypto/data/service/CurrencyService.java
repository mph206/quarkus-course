package tech.donau.crypto.data.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import tech.donau.crypto.data.Currency;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;


// Fetch json from the configKey in application.properties and returns a Currency
@RegisterRestClient(configKey = "config.api.crypto")
//@Path("/ticker")
@Path("/echo")
public interface CurrencyService {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<Currency> getCurrency(@QueryParam("id") String id);


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendFile(@MultipartForm MultipartBody body);

}
