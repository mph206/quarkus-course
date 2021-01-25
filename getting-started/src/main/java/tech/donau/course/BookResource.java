package tech.donau.course;

import io.netty.util.internal.StringUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/book")
public class BookResource {

    private static List<String> books = new ArrayList<>();

    static {
        books.add("Harry Potter 1");
        books.add("Harry Potter 2");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return StringUtil.join(", ", books).toString();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) { // book is the body of the POST request
        books.add(book);
        return book;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBook(@PathParam("id") Integer index, String book) { // quarkus converts input to specified type
        books.remove((int) index);
        books.add(index, book);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@PathParam("id") Integer index) {
        return books.remove((int) index);
    }
}
