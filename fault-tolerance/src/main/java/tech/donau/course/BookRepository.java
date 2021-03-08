package tech.donau.course;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;
import tech.donau.course.data.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Path("/book")
public class BookRepository {
    public static Logger LOGGER = Logger.getLogger(BookRepository.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 1, delay = 1000L)
    @Fallback(fallbackMethod = "getFallbackBooks")

//    Disables whole service if you have constant errors
    @CircuitBreaker(failureRatio = 0.5, failOn = RuntimeException.class)
//    @Timeout(3000)
    public List<Book> getBooks() {
        final boolean fail = new Random().nextBoolean();
        if (fail) {
            LOGGER.info("Could not connect to DB");
//            Thread.sleep(2000L);
            throw new RuntimeException("Couldn't connect to database");
        }
        return Arrays.asList(
                new Book("martin", "1", "Martiny"),
                new Book("martin", "2", "Martiny2"),
                new Book("martin", "3", "Martiny3")
        );
    }

    public List<Book> getFallbackBooks() {
            LOGGER.info("fallback called");
        return Arrays.asList(
                new Book("Fallback martin", "1", "Martiny"),
                new Book("fallback martin", "2", "Martiny2"),
                new Book("martin", "3", "Martiny3")
        );
    }
}