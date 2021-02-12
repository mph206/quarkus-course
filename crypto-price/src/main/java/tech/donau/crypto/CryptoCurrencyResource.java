package tech.donau.crypto;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import tech.donau.crypto.data.Currency;
import tech.donau.crypto.data.service.CurrencyService;
import tech.donau.crypto.data.service.MultipartBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.util.Collection;

//@Path("/crypto")
@Path("/echo")
public class CryptoCurrencyResource {

    @Inject
    @RestClient
    private CurrencyService currencyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Currency> getCrypto(@QueryParam("id") String id) {
        return currencyService.getCurrency(id);
    }

//     consumes form data, which lets you send a file in the body of the POST request which takes name and file keys
//    returns the file contents as text
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile(String body) {
        return body;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String callEcho() {
        final MultipartBody multipartBody = new MultipartBody();
        multipartBody.setFile(new ByteArrayInputStream("Hello, world".getBytes()));
        multipartBody.setName("hello.txt");
        return currencyService.sendFile(multipartBody);
    }
}