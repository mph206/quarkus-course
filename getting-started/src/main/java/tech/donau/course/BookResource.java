package tech.donau.course;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import org.checkerframework.common.value.qual.IntRangeFromGTENegativeOne;
import tech.donau.course.data.Book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    @DataSource("hello")
    AgroalDataSource dataSource;

    @Inject
    @DataSource("users")
    AgroalDataSource usersDataSource;

    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("Harry Potter 1", "JK Rowling", 1));
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() throws SQLException {
        final CallableStatement call = dataSource.getConnection().prepareCall("select * from greeting");
        call.execute();
        final ResultSet resultSet = call.getResultSet();
        resultSet.next();
        resultSet.next();
        final String hello = resultSet.getString(2);

        final CallableStatement call2 = usersDataSource.getConnection().prepareCall("select * from user");
        call2.execute();
        final ResultSet userSet = call2.getResultSet();
        userSet.next();

        return hello + " " + userSet.getString(2);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        return Response.status(200).entity(books).build();
//        return Response.ok(books).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(@Valid Book book) { // book is the body of the POST request
        if (books.size() > 5) {
            return Response.status(400).entity("No more than 5 books allowed").build();
        }
        books.add(book);
        return Response.accepted(book).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") Integer index, Book book) { // quarkus converts input to specified type
        books.remove((int) index);
        books.add(index, book);
        return Response.accepted(book).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book deleteBook(@PathParam("id") Integer index) {
        return books.remove((int) index);
    }
}
